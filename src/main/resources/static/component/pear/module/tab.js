layui.define(['jquery', 'element'], function(exports) {
    "use strict";

    var MOD_NAME = 'tab',
        $ = layui.jquery,
        element = layui.element;

    var pearTab = function(opt) {
        this.option = opt;
    };

    var tabData = new Array();
    var tabDataCurrent = 0;
    var contextTabDOM;

    pearTab.prototype.render = function(opt) {

        var option = {
            elem: opt.elem,
            data: opt.data,
            tool: opt.tool,
            roll: opt.roll,
            index: opt.index,
            width: opt.width,
            height: opt.height,
            tabMax: opt.tabMax,
            session: opt.session ? opt.session : false,
            closeEvent: opt.closeEvent,
            success: opt.success ? opt.success : function(id) {}
        }

        if (option.session) {
            if (sessionStorage.getItem(option.elem + "-pear-tab-data") != null) {
                tabData = JSON.parse(sessionStorage.getItem(option.elem + "-pear-tab-data"));
                option.data = JSON.parse(sessionStorage.getItem(option.elem + "-pear-tab-data"));
                tabDataCurrent = sessionStorage.getItem(option.elem + "-pear-tab-data-current");
                tabData.forEach(function(item, index) {
                    if (item.id == tabDataCurrent) {
                        option.index = index;
                    }
                })
            } else {
                tabData = opt.data;
            }
        }

        var lastIndex;
        var tab = createTab(option);
        $("#" + option.elem).html(tab);
        $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-prev").click(function() {
            rollPage("left", option);
        })
        $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-next").click(function() {
            rollPage("right", option);
        })
        element.init();
        toolEvent(option);
        $("#" + option.elem).width(opt.width);
        $("#" + option.elem).height(opt.height);
        $("#" + option.elem).css({
            position: "relative"
        });
        closeEvent(option);

        option.success(sessionStorage.getItem(option.elem + "-pear-tab-data-current"));

        $("body .layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title").on("contextmenu", "li", function(e) {
            // ????????????????????????
            var top = e.clientY;
            var left = e.clientX;
            var menuWidth = 100;
            var currentId = $(this).attr("lay-id");
            var menu = "<ul><li class='item' id='" + option.elem + "closeThis'>????????????</li><li class='item' id='" + option.elem +
                "closeOther'>????????????</li><li class='item' id='" + option.elem + "closeAll'>????????????</li></ul>";

            contextTabDOM = $(this);
            var isOutsideBounds = (left + menuWidth) > $(window).width();
            if(isOutsideBounds){
                left = $(window).width() - menuWidth;
            }
            // ?????????
            layer.open({
                type: 1,
                title: false,
                shade: false,
                skin: 'pear-tab-menu',
                closeBtn: false,
                area: [menuWidth + 'px', '108px'],
                fixed: true,
                anim: false,
                isOutAnim: false,
                offset: [top, left],
                content: menu, //iframe???url,
                success: function(layero, index) {
                    layer.close(lastIndex);
                    lastIndex = index;
                    menuEvent(option, index);
                    var timer;
                    $(layero).on('mouseout', function() {
                        timer = setTimeout(function() {
                            layer.close(index);
                        }, 30)
                    });

                    $(layero).on('mouseover', function() {
                        clearTimeout(timer);
                    });

                    // ?????? item ??????
                    $(layero).on('contextmenu', function() {
                        return false;
                    })

                }
            });
            return false;
        })

        return new pearTab(option);
    }

    pearTab.prototype.click = function(callback) {
        var elem = this.option.elem;
        var option = this.option;
        element.on('tab(' + this.option.elem + ')', function(data) {
            var id = $("#" + elem + " .layui-tab-title .layui-this").attr("lay-id");
            sessionStorage.setItem(option.elem + "-pear-tab-data-current", id);
            callback(id);
        });
    }

    pearTab.prototype.positionTab = function() {
        var $tabTitle = $('.layui-tab[lay-filter=' + this.option.elem + ']  .layui-tab-title');
        var autoLeft = 0;
        $tabTitle.children("li").each(function() {
            if ($(this).hasClass('layui-this')) {
                return false;
            } else {
                autoLeft += $(this).outerWidth();
            }
        });
        $tabTitle.animate({
            scrollLeft: autoLeft - $tabTitle.width() / 3
        }, 200);
    }

    pearTab.prototype.clear = function() {
        sessionStorage.removeItem(this.option.elem + "-pear-tab-data");
        sessionStorage.removeItem(this.option.elem + "-pear-tab-data-current");
    }

    pearTab.prototype.addTab = function(opt) {
        var title = '';
        if (opt.close) {
            title += '<span class="pear-tab-active"></span><span class="able-close title">' + opt.title +
                '</span><i class="layui-icon layui-unselect layui-tab-close">???</i>';
        } else {
            title += '<span class="pear-tab-active"></span><span class="disable-close title">' + opt.title +
                '</span><i class="layui-icon layui-unselect layui-tab-close">???</i>';
        }
        element.tabAdd(this.option.elem, {
            title: title,
            content: '<iframe id="' + opt.id + '" data-frameid="' + opt.id + '" scrolling="auto" frameborder="0" src="' +
                opt.url + '" style="width:100%;height:100%;"></iframe>',
            id: opt.id
        });
        tabData.push(opt);
        sessionStorage.setItem(this.option.elem + "-pear-tab-data", JSON.stringify(tabData));
        sessionStorage.setItem(this.option.elem + "-pear-tab-data-current", opt.id);
        element.tabChange(this.option.elem, opt.id);
    }

    var index = 0;

    // ???????????? fliter ??????, ?????????????????????
    pearTab.prototype.changeTabTitleById = function(elem, id, title) {
        var currentTab = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title [lay-id='" + id + "'] .title");
        currentTab.html(title);
    }

    // ???????????? filter ??????, ?????????????????????
    pearTab.prototype.delTabByElem = function(elem, id, callback) {
        var currentTab = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title [lay-id='" + id + "']");
        if (currentTab.find("span").is(".able-close")) {
            tabDelete(elem, id, callback);
        }
    }

    // ???????????? filter ??????, ?????????????????????
    pearTab.prototype.delOtherTabByElem = function(elem, callback) {
        var currentId = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title .layui-this").attr("lay-id");
        var tabtitle = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title li");
        $.each(tabtitle, function(i) {
            if ($(this).attr("lay-id") != currentId) {
                if ($(this).find("span").is(".able-close")) {
                    tabDelete(elem, $(this).attr("lay-id"), callback);
                }
            }
        })
    }

    // ???????????? filter ??????, ?????????????????????
    pearTab.prototype.delAllTabByElem = function(elem, callback) {
        var currentId = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title .layui-this").attr("lay-id");
        var tabtitle = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title li");
        $.each(tabtitle, function(i) {
            if ($(this).find("span").is(".able-close")) {
                tabDelete(elem, $(this).attr("lay-id"), callback);
            }
        })
    }

    // ???????????? filter ??????, ?????????????????????
    pearTab.prototype.delCurrentTabByElem = function(elem, callback) {
        var currentTab = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title .layui-this");
        if (currentTab.find("span").is(".able-close")) {
            var currentId = currentTab.attr("lay-id");
            tabDelete(elem, currentId, callback);
        }
    }

    // ???????????? filter ??????, ???????????????
    pearTab.prototype.addTabOnlyByElem = function(elem, opt, time) {
        var title = '';
        if (opt.close) {
            title += '<span class="pear-tab-active"></span><span class="able-close title">' + opt.title +
                '</span><i class="layui-icon layui-unselect layui-tab-close">???</i>'
        } else {
            title += '<span class="pear-tab-active"></span><span class="disable-close title">' + opt.title +
                '</span><i class="layui-icon layui-unselect layui-tab-close">???</i>'
        }
        if ($(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title li[lay-id]").length <= 0) {
            element.tabAdd(elem, {
                title: title,
                content: '<iframe id="' + opt.id + '" data-frameid="' + opt.id + '" scrolling="auto" frameborder="0" src="' +
                    opt.url + '" style="width:100%;height:100%;"></iframe>',
                id: opt.id
            });
            if (time != false && time != 0) {
                tabIframeLoading(elem, opt.id);
            }
            tabData.push(opt);
            sessionStorage.setItem(elem + "-pear-tab-data", JSON.stringify(tabData));
        } else {
            var isData = false;
            $.each($(".layui-tab[lay-filter='" + elem + "'] .layui-tab-title li[lay-id]"), function() {
                if ($(this).attr("lay-id") == opt.id) {
                    isData = true;
                }
            })

            if (isData == false) {
                element.tabAdd(elem, {
                    title: title,
                    content: '<iframe id="' + opt.id + '" data-frameid="' + opt.id + '" scrolling="auto" frameborder="0" src="' +
                        opt.url + '" style="width:100%;height:100%;"></iframe>',
                    id: opt.id
                });
                if (time != false && time != 0) {
                    tabIframeLoading(elem, opt.id);
                }
                tabData.push(opt);
                sessionStorage.setItem(elem + "-pear-tab-data", JSON.stringify(tabData));

            }
        }
        sessionStorage.setItem(elem + "-pear-tab-data-current", opt.id);
        element.tabChange(elem, opt.id);
    }

    /** ??? ??? ??? ??? ??? ??? ??? */
    pearTab.prototype.addTabOnly = function(opt, time) {
        var title = '';
        if (opt.close) {
            title += '<span class="pear-tab-active"></span><span class="able-close title">' + opt.title +
                '</span><i class="layui-icon layui-unselect layui-tab-close">???</i>';
        } else {
            title += '<span class="pear-tab-active"></span><span class="disable-close title">' + opt.title +
                '</span><i class="layui-icon layui-unselect layui-tab-close">???</i>';
        }
        if ($(".layui-tab[lay-filter='" + this.option.elem + "'] .layui-tab-title li[lay-id]").length <= 0) {
            element.tabAdd(this.option.elem, {
                title: title,
                content: '<iframe id="' + opt.id + '" data-frameid="' + opt.id + '" scrolling="auto" frameborder="0" src="' +
                    opt.url + '" style="width:100%;height:100%;"></iframe>',
                id: opt.id
            });
            if (time != false && time != 0) {
                tabIframeLoading(this.option.elem, opt.id);
            }
            tabData.push(opt);
            sessionStorage.setItem(this.option.elem + "-pear-tab-data", JSON.stringify(tabData));
            sessionStorage.setItem(this.option.elem + "-pear-tab-data-current", opt.id);
        } else {
            var isData = false;
            $.each($(".layui-tab[lay-filter='" + this.option.elem + "'] .layui-tab-title li[lay-id]"), function() {
                if ($(this).attr("lay-id") == opt.id) {
                    isData = true;
                }
            })
            if (isData == false) {

                if(this.option.tabMax != false) {
                    if ($(".layui-tab[lay-filter='" + this.option.elem + "'] .layui-tab-title li[lay-id]").length >= this.option.tabMax) {
                        layer.msg("????????????" + this.option.tabMax + "????????????", {
                            icon: 2,
                            time: 1000,
                            shift: 6
                        });
                        return false;
                    }
                }

                element.tabAdd(this.option.elem, {
                    title: title,
                    content: '<iframe id="' + opt.id + '" data-frameid="' + opt.id + '" scrolling="auto" frameborder="0" src="' +
                        opt.url + '" style="width:100%;height:100%;"></iframe>',
                    id: opt.id
                });
                if (time != false && time != 0) {
                    tabIframeLoading(this.option.elem, opt.id);
                }
                tabData.push(opt);
                sessionStorage.setItem(this.option.elem + "-pear-tab-data", JSON.stringify(tabData));
                sessionStorage.setItem(this.option.elem + "-pear-tab-data-current", opt.id);
            }
        }
        element.tabChange(this.option.elem, opt.id);
        sessionStorage.setItem(this.option.elem + "-pear-tab-data-current", opt.id);
    }

    // ??? ??? ??? ??? ??? ??? ??? ???
    pearTab.prototype.refresh = function (time) {
        // ??? ??? ??? ??? ??? ??? ??? ???
        if (time != false && time != 0) {
            tabIframeLoading(this.option.elem);
        } else {
            var $iframe = $(".layui-tab[lay-filter='" + this.option.elem + "'] .layui-tab-content .layui-show").find("iframe");
            $iframe.attr("src", $iframe.attr("src"));
        }
    }

    function tabIframeLoading(elem, id) {
        var load = '<div id="pear-tab-loading' + index + '" class="pear-tab-loading">' +
            '<div class="ball-loader">' +
            '<span></span><span></span><span></span><span></span>' +
            '</div>' +
            '</div>'
        var $iframe = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-content .layui-show").find("iframe");
        if(id){
            $iframe = $(".layui-tab[lay-filter='" + elem + "'] .layui-tab-content").find("iframe[id='"+ id +"']");
        }
        // loading ??? iframe ????????????, ???????????? tab ??????,?????? tab ?????????????????????
        $iframe.parent().append(load);
        var pearLoad = $("#" + elem).find("#pear-tab-loading" + index);
        pearLoad.css({ display: "block" });
        index++;
        $iframe.attr("src", $iframe.attr("src")); // ?????????????????? iframe
        $iframe.load(function () {
            pearLoad.fadeOut(1000, function () {
                pearLoad.remove();
            });
        })
    }


    function tabDelete(elem, id, callback, option) {

        //?????? elem id ?????????????????? layui title li
        var tabTitle = $(".layui-tab[lay-filter='" + elem + "']").find(".layui-tab-title");

        // ???????????? id ??? title
        var removeTab = tabTitle.find("li[lay-id='" + id + "']");
        var nextNode = removeTab.next("li");
        if (!removeTab.hasClass("layui-this")) {
            removeTab.remove();
            var tabContent = $(".layui-tab[lay-filter='" + elem + "']").find("iframe[id='" + id + "']").parent();
            tabContent.remove();

            tabData = JSON.parse(sessionStorage.getItem(elem + "-pear-tab-data"));
            tabDataCurrent = sessionStorage.getItem(elem + "-pear-tab-data-current");
            tabData = tabData.filter(function(item) {
                return item.id != id;
            })
            sessionStorage.setItem(elem + "-pear-tab-data", JSON.stringify(tabData));
            return false;
        }

        var currId;
        if (nextNode.length) {
            nextNode.addClass("layui-this");
            currId = nextNode.attr("lay-id");
            $("#" + elem + " [id='" + currId + "']").parent().addClass("layui-show");
        } else {
            var prevNode = removeTab.prev("li");
            prevNode.addClass("layui-this");
            currId = prevNode.attr("lay-id");
            $("#" + elem + " [id='" + currId + "']").parent().addClass("layui-show");
        }
        callback(currId);
        tabData = JSON.parse(sessionStorage.getItem(elem + "-pear-tab-data"));
        tabDataCurrent = sessionStorage.getItem(elem + "-pear-tab-data-current");
        tabData = tabData.filter(function(item) {
            return item.id != id;
        })
        sessionStorage.setItem(elem + "-pear-tab-data", JSON.stringify(tabData));
        sessionStorage.setItem(elem + "-pear-tab-data-current", currId);

        removeTab.remove();
        // ?????? content
        var tabContent = $(".layui-tab[lay-filter='" + elem + "']").find("iframe[id='" + id + "']").parent();
        // ??????
        tabContent.remove();
    }

    function createTab(option) {

        var type = "";
        var types = option.type + " ";
        if (option.roll == true) {
            type = "layui-tab-roll";
        }
        if (option.tool != false) {
            type = "layui-tab-tool";
        }
        if (option.roll == true && option.tool != false) {
            type = "layui-tab-rollTool";
        }
        var tab = '<div class="pear-tab ' + types + type + ' layui-tab" lay-filter="' + option.elem +
            '" lay-allowClose="true">';
        var title = '<ul class="layui-tab-title">';
        var content = '<div class="layui-tab-content">';
        var control =
            '<div class="layui-tab-control"><li class="layui-tab-prev layui-icon layui-icon-left"></li><li class="layui-tab-next layui-icon layui-icon-right"></li><li class="layui-tab-tool layui-icon layui-icon-down"><ul class="layui-nav" lay-filter=""><li class="layui-nav-item"><a href="javascript:;"></a><dl class="layui-nav-child">';

        // ??? ??? ??? ??? ??? ??? ???
        var index = 0;
        $.each(option.data, function(i, item) {
            var TitleItem = '';
            if (option.index == index) {
                TitleItem += '<li lay-id="' + item.id + '" class="layui-this"><span class="pear-tab-active"></span>';
            } else {
                TitleItem += '<li lay-id="' + item.id + '" ><span class="pear-tab-active"></span>';
            }

            if (item.close) {
                // ??? ??? ??? ??? ??? ??? ??? ??? ???
                TitleItem += '<span class="able-close title">' + item.title + '</span>';
            } else {
                // ??? ??? ??? ??? ??? ??? ??? ??? ??? ???
                TitleItem += '<span class="disable-close title">' + item.title + '</span>';
            }
            TitleItem += '<i class="layui-icon layui-unselect layui-tab-close">???</i></li>';
            title += TitleItem;
            if (option.index == index) {

                // ??? ??? ??? ??? ??? ???
                content += '<div class="layui-show layui-tab-item"><iframe id="' + item.id + '" data-frameid="' + item.id +
                    '"  src="' + item.url +
                    '" frameborder="no" border="0" marginwidth="0" marginheight="0" style="width: 100%;height: 100%;"></iframe></div>'
            } else {
                // ??? ??? ??? ??? ??? ???
                content += '<div class="layui-tab-item"><iframe id="' + item.id + '" data-frameid="' + item.id + '"  src="' +
                    item.url +
                    '" frameborder="no" border="0" marginwidth="0" marginheight="0" style="width: 100%;height: 100%;"></iframe></div>'
            }
            index++;
        });

        title += '</ul>';
        content += '</div>';
        control += '<dd id="closeThis"><a href="#">??? ??? ??? ???</a></dd>'
        control += '<dd id="closeOther"><a href="#">??? ??? ??? ???</a></dd>'
        control += '<dd id="closeAll"><a href="#">??? ??? ??? ???</a></dd>'
        control += '</dl></li></ul></li></div>';

        tab += title;
        tab += control;
        tab += content;
        tab += '</div>';
        tab += ''
        return tab;
    }

    function rollPage(d, option) {
        var $tabTitle = $('#' + option.elem + '  .layui-tab-title');
        var left = $tabTitle.scrollLeft();
        if ('left' === d) {
            $tabTitle.animate({
                scrollLeft: left - 450
            }, 200);
        } else {
            $tabTitle.animate({
                scrollLeft: left + 450
            }, 200);
        }
    }

    function closeEvent(option) {
        $(".layui-tab[lay-filter='" + option.elem + "']").on("click", ".layui-tab-close", function() {
            var layid = $(this).parent().attr("lay-id");
            tabDelete(option.elem, layid, option.closeEvent, option);
        })
    }

    function menuEvent(option, index) {

        $("#" + option.elem + "closeThis").click(function() {
            var currentTab = contextTabDOM;

            if (currentTab.find("span").is(".able-close")) {
                var currentId = currentTab.attr("lay-id");
                tabDelete(option.elem, currentId, option.closeEvent, option);
            } else {
                layer.msg("???????????????????????????", {
                    icon: 3,
                    time: 800
                })
            }
            layer.close(index);
        })

        $("#" + option.elem + "closeOther").click(function() {
            var currentId = contextTabDOM.attr("lay-id");
            var tabtitle = $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title li");
            $.each(tabtitle, function(i) {
                if ($(this).attr("lay-id") != currentId) {
                    if ($(this).find("span").is(".able-close")) {
                        tabDelete(option.elem, $(this).attr("lay-id"), option.closeEvent, option);
                    }
                }
            })
            layer.close(index);
        })

        $("#" + option.elem + "closeAll").click(function() {
            var currentId = contextTabDOM.attr("lay-id");
            var tabtitle = $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title li");
            $.each(tabtitle, function(i) {
                if ($(this).find("span").is(".able-close")) {
                    tabDelete(option.elem, $(this).attr("lay-id"), option.closeEvent, option);
                }
            })
            layer.close(index);
        })
    }


    function toolEvent(option) {

        $("body .layui-tab[lay-filter='" + option.elem + "']").on("click", "#closeThis", function() {
            var currentTab = $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title .layui-this");
            if (currentTab.find("span").is(".able-close")) {
                var currentId = currentTab.attr("lay-id");
                tabDelete(option.elem, currentId, option.closeEvent, option);
            } else {
                layer.msg("???????????????????????????", {
                    icon: 3,
                    time: 800
                })
            }
        })

        $("body .layui-tab[lay-filter='" + option.elem + "']").on("click", "#closeOther", function() {
            var currentId = $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title .layui-this").attr("lay-id");
            var tabtitle = $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title li");
            $.each(tabtitle, function(i) {
                if ($(this).attr("lay-id") != currentId) {
                    if ($(this).find("span").is(".able-close")) {
                        tabDelete(option.elem, $(this).attr("lay-id"), option.closeEvent, option);
                    }
                }
            })
        })

        $("body .layui-tab[lay-filter='" + option.elem + "']").on("click", "#closeAll", function() {
            var currentId = $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title .layui-this").attr("lay-id");
            var tabtitle = $(".layui-tab[lay-filter='" + option.elem + "'] .layui-tab-title li");
            $.each(tabtitle, function(i) {
                if ($(this).find("span").is(".able-close")) {
                    tabDelete(option.elem, $(this).attr("lay-id"), option.closeEvent, option);
                }
            })
        })
    }

    exports(MOD_NAME, new pearTab());
})
