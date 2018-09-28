(function ($) {
    $.fn.lazyload = function (options) {
        var settings = {
            threshold: 0,
            failure_limit: 0,
            event: "scroll",
            effect: "show",
            container: window,
            skip_invisible: true
        };

        if (options) {
            /* Maintain BC for a couple of version. */
            if (null !== options.failurelimit) {
                options.failure_limit = options.failurelimit;
                delete options.failurelimit;
            }

            $.extend(settings, options);
        }

        /* Fire one scroll event per scroll. Not one scroll event per image. */
        var elements = this;
        if (0 == settings.event.indexOf("scroll")) {
            $(settings.container).bind(settings.event, function (event) {
                var counter = 0;
                elements.each(function () {
                    if (settings.skip_invisible && !$(this).is(":visible")) return;
                    if ($.abovethetop(this, settings) ||
                        $.leftofbegin(this, settings)) {
                        /* Nothing. */
                    } else if (!$.belowthefold(this, settings) &&
                        !$.rightoffold(this, settings)) {
                        $(this).trigger("appear");
                    } else {
                        if (++counter > settings.failure_limit) {
                            return false;
                        }
                    }
                });

                /* Remove image from array so it is not looped next time. */
                var temp = $.grep(elements, function (element) {
                    return !element.loaded;
                });
                elements = $(temp);

            });
        }

        this.each(function () {
            var self = this;
            self.loaded = false;

            /* When appear is triggered load original image. */
            $(self).one("appear", function () {
                if (!this.loaded) {
                    $("<img />")
                        .bind("load", function () {
                            $(self)
                                .hide()
                                .attr("src", $(self).data("original"))
                                [settings.effect](settings.effectspeed);
                            self.loaded = true;
                        })
                        .attr("src", $(self).data("original"));
                }
                ;
            });

            /* When wanted event is triggered load original image */
            /* by triggering appear.                              */
            if (0 != settings.event.indexOf("scroll")) {
                $(self).bind(settings.event, function (event) {
                    if (!self.loaded) {
                        $(self).trigger("appear");
                    }
                });
            }
        });

        /* Check if something appears when window is resized. */
        $(window).bind("resize", function (event) {
            $(settings.container).trigger(settings.event);
        });

        /* Force initial check if images should appear. */
        $(settings.container).trigger(settings.event);

        return this;

    };

    /* Convenience methods in jQuery namespace.           */
    /* Use as  $.belowthefold(element, {threshold : 100, container : window}) */

    $.belowthefold = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).height() + $(window).scrollTop();
        } else {
            var fold = $(settings.container).offset().top + $(settings.container).height();
        }
        return fold <= $(element).offset().top - settings.threshold;
    };

    $.rightoffold = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).width() + $(window).scrollLeft();
        } else {
            var fold = $(settings.container).offset().left + $(settings.container).width();
        }
        return fold <= $(element).offset().left - settings.threshold;
    };

    $.abovethetop = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).scrollTop();
        } else {
            var fold = $(settings.container).offset().top;
        }
        return fold >= $(element).offset().top + settings.threshold + $(element).height();
    };

    $.leftofbegin = function (element, settings) {
        if (settings.container === undefined || settings.container === window) {
            var fold = $(window).scrollLeft();
        } else {
            var fold = $(settings.container).offset().left;
        }
        return fold >= $(element).offset().left + settings.threshold + $(element).width();
    };
    /* Custom selectors for your convenience.   */
    /* Use as $("img:below-the-fold").something() */

    $.extend($.expr[':'], {
        "below-the-fold": function (a) {
            return $.belowthefold(a, {threshold: 0, container: window})
        },
        "above-the-fold": function (a) {
            return !$.belowthefold(a, {threshold: 0, container: window})
        },
        "right-of-fold": function (a) {
            return $.rightoffold(a, {threshold: 0, container: window})
        },
        "left-of-fold": function (a) {
            return !$.rightoffold(a, {threshold: 0, container: window})
        }
    });

})(jQuery);

function setlazy_load() {
    $("img.lazy_load").lazyload({
        effect: "fadeIn", //渐现，show(直接显示),fadeIn(淡入),slideDown(下拉)
        threshold: liwidth, //预加载，在图片距离屏幕180px时提前载入
        event: 'scroll',  // 事件触发时才加载，click(点击),mouseover(鼠标划过),sporty(运动的),默认为scroll（滑动）
        container: $(".licontent"), // 指定对某容器中的图片实现效果
        failure_limit: 2 //加载2张可见区域外的图片,lazyload默认在找到第一张不在可见区域里的图片时则不再继续加载,但当HTML容器混乱的时候可能出现可见区域内图片并没加载出来的情况
    });
}

$.extend({
    postForm: function (url, args) {
        var form = $("<form method='post' style='display:none'></form>"), input;
        form.attr({"action": url});
        $.each(args, function (key, value) {
            input = $("<input type='hidden'>");
            input.attr({"name": key});
            input.val(value);
            form.append(input);
        });

        //IE低版本和火狐下
        form.appendTo(document.body);
        form.submit();
        document.body.removeChild(form[0]);
    },
    postJson: function (url, data, func) {

        $.ajax({
            url: url,
            type: 'post',
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: func
        });
    },
    postJsonSyn: function (url, data, func) {
        $.ajax({
            url: url,
            async: false,
            type: 'post',
            dataType: 'json',
            xhrFields: {
                withCredentials: true
            },
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: func
        });
    },
    postCross: function (url, data, func) {
        url = ctx;
        $.post(url, JSON.data, func);
    },
    timestamptodate: function (inputTime) {
        var date = new Date(inputTime);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? ('0' + m) : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        var h = date.getHours();
        h = h < 10 ? ('0' + h) : h;
        var minute = date.getMinutes();
        var second = date.getSeconds();
        minute = minute < 10 ? ('0' + minute) : minute;
        second = second < 10 ? ('0' + second) : second;
        return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
    },
    getServerPath: function () {
        if (!_server_path == '') {
            return _server_path;
        }
        var curWwwPath = window.document.location.href;
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        var localhostPaht = curWwwPath.substring(0, pos);
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        return (localhostPaht + projectName);
    }

});


