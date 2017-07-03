/**
 * Created by puneethts on 1/23/15.
 */
/*
 AngularJS v1.2.0
 (c) 2010-2012 Google, Inc. http://angularjs.org
 License: MIT
 */
(function(t,c,B){'use strict';function w(s,r,g,a,h){return{restrict:"ECA",terminal:!0,priority:400,transclude:"element",compile:function(k,d,A){return function(u,k,d){function v(){l&&(l.$destroy(),l=null);m&&(h.leave(m),m=null)}function x(){var f=s.current&&s.current.locals,y=f&&f.$template;if(y){var z=u.$new();A(z,function(e){e.html(y);h.enter(e,null,m||k,function(){!c.isDefined(n)||n&&!u.$eval(n)||r()});v();var p=g(e.contents()),q=s.current;l=q.scope=z;m=e;if(q.controller){f.$scope=l;var d=a(q.controller,
    f);q.controllerAs&&(l[q.controllerAs]=d);e.data("$ngControllerController",d);e.children().data("$ngControllerController",d)}p(l);l.$emit("$viewContentLoaded");l.$eval(b)})}else v()}var l,m,n=d.autoscroll,b=d.onload||"";u.$on("$routeChangeSuccess",x);x()}}}}t=c.module("ngRoute",["ng"]).provider("$route",function(){function s(a,h){return c.extend(new (c.extend(function(){},{prototype:a})),h)}function r(a,c){var k=c.caseInsensitiveMatch,d={originalPath:a,regexp:a},g=d.keys=[];a=a.replace(/([().])/g,
    "\\$1").replace(/(\/)?:(\w+)([\?|\*])?/g,function(a,c,h,d){a="?"===d?d:null;d="*"===d?d:null;g.push({name:h,optional:!!a});c=c||"";return""+(a?"":c)+"(?:"+(a?c:"")+(d&&"(.+?)"||"([^/]+)")+(a||"")+")"+(a||"")}).replace(/([\/$\*])/g,"\\$1");d.regexp=RegExp("^"+a+"$",k?"i":"");return d}var g={};this.when=function(a,h){g[a]=c.extend({reloadOnSearch:!0},h,a&&r(a,h));if(a){var k="/"==a[a.length-1]?a.substr(0,a.length-1):a+"/";g[k]=c.extend({redirectTo:a},r(k,h))}return this};this.otherwise=function(a){this.when(null,
    a);return this};this.$get=["$rootScope","$location","$routeParams","$q","$injector","$http","$templateCache","$sce",function(a,h,k,d,r,u,t,w){function v(){var b=x(),f=n.current;if(b&&f&&b.$$route===f.$$route&&c.equals(b.pathParams,f.pathParams)&&!b.reloadOnSearch&&!m)f.params=b.params,c.copy(f.params,k),a.$broadcast("$routeUpdate",f);else if(b||f)m=!1,a.$broadcast("$routeChangeStart",b,f),(n.current=b)&&b.redirectTo&&(c.isString(b.redirectTo)?h.path(l(b.redirectTo,b.params)).search(b.params).replace():
    h.url(b.redirectTo(b.pathParams,h.path(),h.search())).replace()),d.when(b).then(function(){if(b){var a=c.extend({},b.resolve),f,e;c.forEach(a,function(b,f){a[f]=c.isString(b)?r.get(b):r.invoke(b)});c.isDefined(f=b.template)?c.isFunction(f)&&(f=f(b.params)):c.isDefined(e=b.templateUrl)&&(c.isFunction(e)&&(e=e(b.params)),e=w.getTrustedResourceUrl(e),c.isDefined(e)&&(b.loadedTemplateUrl=e,f=u.get(e,{cache:t}).then(function(b){return b.data})));c.isDefined(f)&&(a.$template=f);return d.all(a)}}).then(function(d){b==
n.current&&(b&&(b.locals=d,c.copy(b.params,k)),a.$broadcast("$routeChangeSuccess",b,f))},function(c){b==n.current&&a.$broadcast("$routeChangeError",b,f,c)})}function x(){var b,a;c.forEach(g,function(d,l){var e;if(e=!a){var p=h.path();e=d.keys;var q={};if(d.regexp)if(p=d.regexp.exec(p)){for(var g=1,k=p.length;g<k;++g){var m=e[g-1],n="string"==typeof p[g]?decodeURIComponent(p[g]):p[g];m&&n&&(q[m.name]=n)}e=q}else e=null;else e=null;e=b=e}e&&(a=s(d,{params:c.extend({},h.search(),b),pathParams:b}),a.$$route=
    d)});return a||g[null]&&s(g[null],{params:{},pathParams:{}})}function l(a,d){var g=[];c.forEach((a||"").split(":"),function(a,b){if(0===b)g.push(a);else{var c=a.match(/(\w+)(.*)/),h=c[1];g.push(d[h]);g.push(c[2]||"");delete d[h]}});return g.join("")}var m=!1,n={routes:g,reload:function(){m=!0;a.$evalAsync(v)}};a.$on("$locationChangeSuccess",v);return n}]});t.provider("$routeParams",function(){this.$get=function(){return{}}});t.directive("ngView",w);w.$inject=["$route","$anchorScroll","$compile","$controller",
    "$animate"]})(window,window.angular);
//# sourceMappingURL=angular-route.min.js.map