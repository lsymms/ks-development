!function(a){"function"==typeof define?define(a):"function"==typeof YUI?YUI.add("es5",a):a()}(function(){function a(){}function b(a){return a=+a,a!==a?a=0:0!==a&&a!==1/0&&a!==-(1/0)&&(a=(a>0||-1)*Math.floor(Math.abs(a))),a}function c(a){var b=typeof a;return null===a||"undefined"===b||"boolean"===b||"number"===b||"string"===b}function d(a){var b,d,e;if(c(a))return a;if(d=a.valueOf,"function"==typeof d&&(b=d.call(a),c(b)))return b;if(e=a.toString,"function"==typeof e&&(b=e.call(a),c(b)))return b;throw new TypeError}Function.prototype.bind||(Function.prototype.bind=function(b){var c=this;if("function"!=typeof c)throw new TypeError("Function.prototype.bind called on incompatible "+c);var d=m.call(arguments,1),e=function(){if(this instanceof e){var a=c.apply(this,d.concat(m.call(arguments)));return Object(a)===a?a:this}return c.apply(b,d.concat(m.call(arguments)))};return c.prototype&&(a.prototype=c.prototype,e.prototype=new a,a.prototype=null),e});var e,f,g,h,i,j=Function.prototype.call,k=Array.prototype,l=Object.prototype,m=k.slice,n=j.bind(l.toString),o=j.bind(l.hasOwnProperty);if((i=o(l,"__defineGetter__"))&&(e=j.bind(l.__defineGetter__),f=j.bind(l.__defineSetter__),g=j.bind(l.__lookupGetter__),h=j.bind(l.__lookupSetter__)),2!=[1,2].splice(0).length){var p=Array.prototype.splice;Array.prototype.splice=function(){function a(a){for(var b=[];a--;)b.unshift(a);return b}var b,c=[];return c.splice.bind(c,0,0).apply(null,a(20)),c.splice.bind(c,0,0).apply(null,a(26)),b=c.length,c.splice(5,0,"XXX"),b+1==c.length?!0:void 0}()?function(a,b){return arguments.length?p.apply(this,[void 0===a?0:a,void 0===b?this.length-a:b].concat(m.call(arguments,2))):[]}:function(a,b){var c,d=m.call(arguments,2),e=d.length;if(!arguments.length)return[];if(void 0===a&&(a=0),void 0===b&&(b=this.length-a),e>0){if(0>=b){if(a==this.length)return this.push.apply(this,d),[];if(0==a)return this.unshift.apply(this,d),[]}return c=m.call(this,a,a+b),d.push.apply(d,m.call(this,a+b,this.length)),d.unshift.apply(d,m.call(this,0,a)),d.unshift(0,this.length),p.apply(this,d),c}return p.call(this,a,b)}}if(1!=[].unshift(0)){var q=Array.prototype.unshift;Array.prototype.unshift=function(){return q.apply(this,arguments),this.length}}Array.isArray||(Array.isArray=function(a){return"[object Array]"==n(a)});var r=Object("a"),s="a"!=r[0]||!(0 in r);if(Array.prototype.forEach||(Array.prototype.forEach=function(a){var b=G(this),c=s&&"[object String]"==n(this)?this.split(""):b,d=arguments[1],e=-1,f=c.length>>>0;if("[object Function]"!=n(a))throw new TypeError;for(;++e<f;)e in c&&a.call(d,c[e],e,b)}),Array.prototype.map||(Array.prototype.map=function(a){var b=G(this),c=s&&"[object String]"==n(this)?this.split(""):b,d=c.length>>>0,e=Array(d),f=arguments[1];if("[object Function]"!=n(a))throw new TypeError(a+" is not a function");for(var g=0;d>g;g++)g in c&&(e[g]=a.call(f,c[g],g,b));return e}),Array.prototype.filter||(Array.prototype.filter=function(a){var b,c=G(this),d=s&&"[object String]"==n(this)?this.split(""):c,e=d.length>>>0,f=[],g=arguments[1];if("[object Function]"!=n(a))throw new TypeError(a+" is not a function");for(var h=0;e>h;h++)h in d&&(b=d[h],a.call(g,b,h,c)&&f.push(b));return f}),Array.prototype.every||(Array.prototype.every=function(a){var b=G(this),c=s&&"[object String]"==n(this)?this.split(""):b,d=c.length>>>0,e=arguments[1];if("[object Function]"!=n(a))throw new TypeError(a+" is not a function");for(var f=0;d>f;f++)if(f in c&&!a.call(e,c[f],f,b))return!1;return!0}),Array.prototype.some||(Array.prototype.some=function(a){var b=G(this),c=s&&"[object String]"==n(this)?this.split(""):b,d=c.length>>>0,e=arguments[1];if("[object Function]"!=n(a))throw new TypeError(a+" is not a function");for(var f=0;d>f;f++)if(f in c&&a.call(e,c[f],f,b))return!0;return!1}),Array.prototype.reduce||(Array.prototype.reduce=function(a){var b=G(this),c=s&&"[object String]"==n(this)?this.split(""):b,d=c.length>>>0;if("[object Function]"!=n(a))throw new TypeError(a+" is not a function");if(!d&&1==arguments.length)throw new TypeError("reduce of empty array with no initial value");var e,f=0;if(arguments.length>=2)e=arguments[1];else for(;;){if(f in c){e=c[f++];break}if(++f>=d)throw new TypeError("reduce of empty array with no initial value")}for(;d>f;f++)f in c&&(e=a.call(void 0,e,c[f],f,b));return e}),Array.prototype.reduceRight||(Array.prototype.reduceRight=function(a){var b=G(this),c=s&&"[object String]"==n(this)?this.split(""):b,d=c.length>>>0;if("[object Function]"!=n(a))throw new TypeError(a+" is not a function");if(!d&&1==arguments.length)throw new TypeError("reduceRight of empty array with no initial value");var e,f=d-1;if(arguments.length>=2)e=arguments[1];else for(;;){if(f in c){e=c[f--];break}if(--f<0)throw new TypeError("reduceRight of empty array with no initial value")}if(0>f)return e;do f in this&&(e=a.call(void 0,e,c[f],f,b));while(f--);return e}),Array.prototype.indexOf&&-1==[0,1].indexOf(1,2)||(Array.prototype.indexOf=function(a){var c=s&&"[object String]"==n(this)?this.split(""):G(this),d=c.length>>>0;if(!d)return-1;var e=0;for(arguments.length>1&&(e=b(arguments[1])),e=e>=0?e:Math.max(0,d+e);d>e;e++)if(e in c&&c[e]===a)return e;return-1}),Array.prototype.lastIndexOf&&-1==[0,1].lastIndexOf(0,-3)||(Array.prototype.lastIndexOf=function(a){var c=s&&"[object String]"==n(this)?this.split(""):G(this),d=c.length>>>0;if(!d)return-1;var e=d-1;for(arguments.length>1&&(e=Math.min(e,b(arguments[1]))),e=e>=0?e:d-Math.abs(e);e>=0;e--)if(e in c&&a===c[e])return e;return-1}),!Object.keys){var t=!0,u=["toString","toLocaleString","valueOf","hasOwnProperty","isPrototypeOf","propertyIsEnumerable","constructor"],v=u.length;for(var w in{toString:null})t=!1;Object.keys=function H(a){if("object"!=typeof a&&"function"!=typeof a||null===a)throw new TypeError("Object.keys called on a non-object");var H=[];for(var b in a)o(a,b)&&H.push(b);if(t)for(var c=0,d=v;d>c;c++){var e=u[c];o(a,e)&&H.push(e)}return H}}var x=-621987552e5,y="-000001";Date.prototype.toISOString&&-1!==new Date(x).toISOString().indexOf(y)||(Date.prototype.toISOString=function(){var a,b,c,d,e;if(!isFinite(this))throw new RangeError("Date.prototype.toISOString called on non-finite value.");for(d=this.getUTCFullYear(),e=this.getUTCMonth(),d+=Math.floor(e/12),e=(e%12+12)%12,a=[e+1,this.getUTCDate(),this.getUTCHours(),this.getUTCMinutes(),this.getUTCSeconds()],d=(0>d?"-":d>9999?"+":"")+("00000"+Math.abs(d)).slice(d>=0&&9999>=d?-4:-6),b=a.length;b--;)c=a[b],10>c&&(a[b]="0"+c);return d+"-"+a.slice(0,2).join("-")+"T"+a.slice(2).join(":")+"."+("000"+this.getUTCMilliseconds()).slice(-3)+"Z"});var z=!1;try{z=Date.prototype.toJSON&&null===new Date(0/0).toJSON()&&-1!==new Date(x).toJSON().indexOf(y)&&Date.prototype.toJSON.call({toISOString:function(){return!0}})}catch(A){}z||(Date.prototype.toJSON=function(){var a,b=Object(this),c=d(b);if("number"==typeof c&&!isFinite(c))return null;if(a=b.toISOString,"function"!=typeof a)throw new TypeError("toISOString property is not callable");return a.call(b)}),Date=function(a){function b(c,d,e,f,g,h,i){var j=arguments.length;if(this instanceof a){var k=1==j&&String(c)===c?new a(b.parse(c)):j>=7?new a(c,d,e,f,g,h,i):j>=6?new a(c,d,e,f,g,h):j>=5?new a(c,d,e,f,g):j>=4?new a(c,d,e,f):j>=3?new a(c,d,e):j>=2?new a(c,d):j>=1?new a(c):new a;return k.constructor=b,k}return a.apply(this,arguments)}function c(a,b){var c=b>1?1:0;return e[b]+Math.floor((a-1969+c)/4)-Math.floor((a-1901+c)/100)+Math.floor((a-1601+c)/400)+365*(a-1970)}var d=new RegExp("^(\\d{4}|[+-]\\d{6})(?:-(\\d{2})(?:-(\\d{2})(?:T(\\d{2}):(\\d{2})(?::(\\d{2})(?:(\\.\\d{1,}))?)?(Z|(?:([-+])(\\d{2}):(\\d{2})))?)?)?)?$"),e=[0,31,59,90,120,151,181,212,243,273,304,334,365];for(var f in a)b[f]=a[f];return b.now=a.now,b.UTC=a.UTC,b.prototype=a.prototype,b.prototype.constructor=b,b.parse=function(b){var e=d.exec(b);if(e){var f,g=Number(e[1]),h=Number(e[2]||1)-1,i=Number(e[3]||1)-1,j=Number(e[4]||0),k=Number(e[5]||0),l=Number(e[6]||0),m=Math.floor(1e3*Number(e[7]||0)),n=!e[4]||e[8]?0:Number(new a(1970,0)),o="-"===e[9]?1:-1,p=Number(e[10]||0),q=Number(e[11]||0);return(k>0||l>0||m>0?24:25)>j&&60>k&&60>l&&1e3>m&&h>-1&&12>h&&24>p&&60>q&&i>-1&&i<c(g,h+1)-c(g,h)&&(f=60*(24*(c(g,h)+i)+j+p*o),f=1e3*(60*(f+k+q*o)+l)+m+n,f>=-864e13&&864e13>=f)?f:0/0}return a.parse.apply(this,arguments)},b}(Date),Date.now||(Date.now=function(){return(new Date).getTime()}),Number.prototype.toFixed&&"0.000"===8e-5.toFixed(3)&&"0"!==.9.toFixed(0)&&"1.25"===1.255.toFixed(2)&&"1000000000000000128"===0xde0b6b3a7640080.toFixed(0)||!function(){function a(a,b){for(var c=-1;++c<g;)b+=a*h[c],h[c]=b%f,b=Math.floor(b/f)}function b(a){for(var b=g,c=0;--b>=0;)c+=h[b],h[b]=Math.floor(c/a),c=c%a*f}function c(){for(var a=g,b="";--a>=0;)if(""!==b||0===a||0!==h[a]){var c=String(h[a]);""===b?b=c:b+="0000000".slice(0,7-c.length)+c}return b}function d(a,b,c){return 0===b?c:b%2===1?d(a,b-1,c*a):d(a*a,b/2,c)}function e(a){for(var b=0;a>=4096;)b+=12,a/=4096;for(;a>=2;)b+=1,a/=2;return b}var f,g,h;f=1e7,g=6,h=[0,0,0,0,0,0],Number.prototype.toFixed=function(f){var g,h,i,j,k,l,m,n;if(g=Number(f),g=g!==g?0:Math.floor(g),0>g||g>20)throw new RangeError("Number.toFixed called with invalid number of decimals");if(h=Number(this),h!==h)return"NaN";if(-1e21>=h||h>=1e21)return String(h);if(i="",0>h&&(i="-",h=-h),j="0",h>1e-21)if(k=e(h*d(2,69,1))-69,l=0>k?h*d(2,-k,1):h/d(2,k,1),l*=4503599627370496,k=52-k,k>0){for(a(0,l),m=g;m>=7;)a(1e7,0),m-=7;for(a(d(10,m,1),0),m=k-1;m>=23;)b(1<<23),m-=23;b(1<<m),a(1,1),b(2),j=c()}else a(0,l),a(1<<-k,0),j=c()+"0.00000000000000000000".slice(2,2+g);return g>0?(n=j.length,j=g>=n?i+"0.0000000000000000000".slice(0,g-n+2)+j:i+j.slice(0,n-g)+"."+j.slice(n-g)):j=i+j,j}}();var B=String.prototype.split;if(2!=="ab".split(/(?:ab)*/).length||4!==".".split(/(.?)(.?)/).length||"t"==="tesst".split(/(s)*/)[1]||0==="".split(/.?/).length||".".split(/()()/).length>1?!function(){var a=void 0===/()??/.exec("")[1];String.prototype.split=function(b,c){var d=this;if(void 0===b&&0===c)return[];if("[object RegExp]"!==Object.prototype.toString.call(b))return B.apply(this,arguments);var e,f,g,h,i=[],j=(b.ignoreCase?"i":"")+(b.multiline?"m":"")+(b.extended?"x":"")+(b.sticky?"y":""),k=0,b=new RegExp(b.source,j+"g");for(d+="",a||(e=new RegExp("^"+b.source+"$(?!\\s)",j)),c=void 0===c?-1>>>0:c>>>0;(f=b.exec(d))&&(g=f.index+f[0].length,!(g>k&&(i.push(d.slice(k,f.index)),!a&&f.length>1&&f[0].replace(e,function(){for(var a=1;a<arguments.length-2;a++)void 0===arguments[a]&&(f[a]=void 0)}),f.length>1&&f.index<d.length&&Array.prototype.push.apply(i,f.slice(1)),h=f[0].length,k=g,i.length>=c)));)b.lastIndex===f.index&&b.lastIndex++;return k===d.length?(h||!b.test(""))&&i.push(""):i.push(d.slice(k)),i.length>c?i.slice(0,c):i}}():"0".split(void 0,0).length&&(String.prototype.split=function(a,b){return void 0===a&&0===b?[]:B.apply(this,arguments)}),"".substr&&"b"!=="0b".substr(-1)){var C=String.prototype.substr;String.prototype.substr=function(a,b){return C.call(this,0>a?(a=this.length+a)<0?0:a:a,b)}}var D="	\n\f\r   ᠎             　\u2028\u2029﻿";if(!String.prototype.trim||D.trim()){D="["+D+"]";var E=new RegExp("^"+D+D+"*"),F=new RegExp(D+D+"*$");String.prototype.trim=function(){if(void 0===this||null===this)throw new TypeError("can't convert "+this+" to object");return String(this).replace(E,"").replace(F,"")}}var G=function(a){if(null==a)throw new TypeError("can't convert "+a+" to object");return Object(a)}}),function(){var a=null;!function(b){function c(b){if(c[b]!==f)return c[b];var d;if("bug-string-char-index"==b)d="a"!="a"[0];else if("json"==b)d=c("json-stringify")&&c("json-parse");else{var e;if("json-stringify"==b){d=j.stringify;var h="function"==typeof d&&k;if(h){(e=function(){return 1}).toJSON=e;try{h="0"===d(0)&&"0"===d(new Number)&&'""'==d(new String)&&d(g)===f&&d(f)===f&&d()===f&&"1"===d(e)&&"[1]"==d([e])&&"[null]"==d([f])&&"null"==d(a)&&"[null,null,null]"==d([f,g,a])&&'{"a":[1,true,false,null,"\\u0000\\b\\n\\f\\r\\t"]}'==d({a:[e,!0,!1,a,"\x00\b\n\f\r	"]})&&"1"===d(a,e)&&"[\n 1,\n 2\n]"==d([1,2],a,1)&&'"-271821-04-20T00:00:00.000Z"'==d(new Date(-864e13))&&'"+275760-09-13T00:00:00.000Z"'==d(new Date(864e13))&&'"-000001-01-01T00:00:00.000Z"'==d(new Date(-621987552e5))&&'"1969-12-31T23:59:59.999Z"'==d(new Date(-1))}catch(i){h=!1}}d=h}if("json-parse"==b){if(d=j.parse,"function"==typeof d)try{if(0===d("0")&&!d(!1)){e=d('{"a":[1,true,false,null,"\\u0000\\b\\n\\f\\r\\t"]}');var l=5==e.a.length&&1===e.a[0];if(l){try{l=!d('"	"')}catch(m){}if(l)try{l=1!==d("01")}catch(n){}if(l)try{l=1!==d("1.")}catch(o){}}}}catch(p){l=!1}d=l}}return c[b]=!!d}var d,e,f,g={}.toString,h="function"==typeof define&&define.amd,i="object"==typeof JSON&&JSON,j="object"==typeof exports&&exports&&!exports.nodeType&&exports;j&&i?(j.stringify=i.stringify,j.parse=i.parse):j=b.JSON=i||{};var k=new Date(-0xc782b5b800cec);try{k=-109252==k.getUTCFullYear()&&0===k.getUTCMonth()&&1===k.getUTCDate()&&10==k.getUTCHours()&&37==k.getUTCMinutes()&&6==k.getUTCSeconds()&&708==k.getUTCMilliseconds()}catch(l){}if(!c("json")){var m=c("bug-string-char-index");if(!k)var n=Math.floor,o=[0,31,59,90,120,151,181,212,243,273,304,334],p=function(a,b){return o[b]+365*(a-1970)+n((a-1969+(b=+(b>1)))/4)-n((a-1901+b)/100)+n((a-1601+b)/400)};(d={}.hasOwnProperty)||(d=function(b){var c,e={};return(e.__proto__=a,e.__proto__={toString:1},e).toString!=g?d=function(b){var c=this.__proto__,b=b in(this.__proto__=a,this);return this.__proto__=c,b}:(c=e.constructor,d=function(a){var b=(this.constructor||c).prototype;return a in this&&!(a in b&&this[a]===b[a])}),e=a,d.call(this,b)});var q={"boolean":1,number:1,string:1,undefined:1};if(e=function(b,c){var f,h,i,j=0;(f=function(){this.valueOf=0}).prototype.valueOf=0,h=new f;for(i in h)d.call(h,i)&&j++;return f=h=a,j?e=2==j?function(a,b){var c,e={},f="[object Function]"==g.call(a);for(c in a)!(f&&"prototype"==c)&&!d.call(e,c)&&(e[c]=1)&&d.call(a,c)&&b(c)}:function(a,b){var c,e,f="[object Function]"==g.call(a);for(c in a)!(f&&"prototype"==c)&&d.call(a,c)&&!(e="constructor"===c)&&b(c);(e||d.call(a,c="constructor"))&&b(c)}:(h=["valueOf","toString","toLocaleString","propertyIsEnumerable","isPrototypeOf","hasOwnProperty","constructor"],e=function(a,b){var c,e,f="[object Function]"==g.call(a);(e=!f)&&(e="function"!=typeof a.constructor)&&(e=typeof a.hasOwnProperty,e="object"==e?!!a.hasOwnProperty:!q[e]),e=e?a.hasOwnProperty:d;for(c in a)!(f&&"prototype"==c)&&e.call(a,c)&&b(c);for(f=h.length;c=h[--f];e.call(a,c)&&b(c));}),e(b,c)},!c("json-stringify")){var r={92:"\\\\",34:'\\"',8:"\\b",12:"\\f",10:"\\n",13:"\\r",9:"\\t"},s=function(a,b){return("000000"+(b||0)).slice(-a)},t=function(a){var b,c='"',d=0,e=a.length,f=e>10&&m;for(f&&(b=a.split(""));e>d;d++){var g=a.charCodeAt(d);switch(g){case 8:case 9:case 10:case 12:case 13:case 34:case 92:c+=r[g];break;default:if(32>g){c+="\\u00"+s(2,g.toString(16));break}c+=f?b[d]:m?a.charAt(d):a[d]}}return c+'"'},u=function(b,c,h,i,j,k,l){var m,o,q,r,v,w,x,y,z;try{m=c[b]}catch(A){}if("object"==typeof m&&m)if(o=g.call(m),"[object Date]"!=o||d.call(m,"toJSON"))"function"==typeof m.toJSON&&("[object Number]"!=o&&"[object String]"!=o&&"[object Array]"!=o||d.call(m,"toJSON"))&&(m=m.toJSON(b));else if(m>-1/0&&1/0>m){if(p){for(r=n(m/864e5),o=n(r/365.2425)+1970-1;p(o+1,0)<=r;o++);for(q=n((r-p(o,0))/30.42);p(o,q+1)<=r;q++);r=1+r-p(o,q),v=(m%864e5+864e5)%864e5,w=n(v/36e5)%24,x=n(v/6e4)%60,y=n(v/1e3)%60,v%=1e3}else o=m.getUTCFullYear(),q=m.getUTCMonth(),r=m.getUTCDate(),w=m.getUTCHours(),x=m.getUTCMinutes(),y=m.getUTCSeconds(),v=m.getUTCMilliseconds();m=(0>=o||o>=1e4?(0>o?"-":"+")+s(6,0>o?-o:o):s(4,o))+"-"+s(2,q+1)+"-"+s(2,r)+"T"+s(2,w)+":"+s(2,x)+":"+s(2,y)+"."+s(3,v)+"Z"}else m=a;if(h&&(m=h.call(c,b,m)),m===a)return"null";if(o=g.call(m),"[object Boolean]"==o)return""+m;if("[object Number]"==o)return m>-1/0&&1/0>m?""+m:"null";if("[object String]"==o)return t(""+m);if("object"==typeof m){for(b=l.length;b--;)if(l[b]===m)throw TypeError();if(l.push(m),z=[],c=k,k+=j,"[object Array]"==o){for(q=0,b=m.length;b>q;q++)o=u(q,m,h,i,j,k,l),z.push(o===f?"null":o);b=z.length?j?"[\n"+k+z.join(",\n"+k)+"\n"+c+"]":"["+z.join(",")+"]":"[]"}else e(i||m,function(a){var b=u(a,m,h,i,j,k,l);b!==f&&z.push(t(a)+":"+(j?" ":"")+b)}),b=z.length?j?"{\n"+k+z.join(",\n"+k)+"\n"+c+"}":"{"+z.join(",")+"}":"{}";return l.pop(),b}};j.stringify=function(a,b,c){var d,e,f,h;if("function"==typeof b||"object"==typeof b&&b)if("[object Function]"==(h=g.call(b)))e=b;else if("[object Array]"==h){f={};for(var i,j=0,k=b.length;k>j;i=b[j++],h=g.call(i),("[object String]"==h||"[object Number]"==h)&&(f[i]=1));}if(c)if("[object Number]"==(h=g.call(c))){if((c-=c%1)>0)for(d="",c>10&&(c=10);d.length<c;d+=" ");}else"[object String]"==h&&(d=c.length<=10?c:c.slice(0,10));return u("",(i={},i[""]=a,i),e,f,d,"",[])}}if(!c("json-parse")){var v,w,x=String.fromCharCode,y={92:"\\",34:'"',47:"/",98:"\b",116:"	",110:"\n",102:"\f",114:"\r"},z=function(){throw v=w=a,SyntaxError()},A=function(){for(var b,c,d,e,f,g=w,h=g.length;h>v;)switch(f=g.charCodeAt(v)){case 9:case 10:case 13:case 32:v++;break;case 123:case 125:case 91:case 93:case 58:case 44:return b=m?g.charAt(v):g[v],v++,b;case 34:for(b="@",v++;h>v;)if(f=g.charCodeAt(v),32>f)z();else if(92==f)switch(f=g.charCodeAt(++v)){case 92:case 34:case 47:case 98:case 116:case 110:case 102:case 114:b+=y[f],v++;break;case 117:for(c=++v,d=v+4;d>v;v++)f=g.charCodeAt(v),f>=48&&57>=f||f>=97&&102>=f||f>=65&&70>=f||z();b+=x("0x"+g.slice(c,v));break;default:z()}else{if(34==f)break;for(f=g.charCodeAt(v),c=v;f>=32&&92!=f&&34!=f;)f=g.charCodeAt(++v);b+=g.slice(c,v)}if(34==g.charCodeAt(v))return v++,b;z();default:if(c=v,45==f&&(e=!0,f=g.charCodeAt(++v)),f>=48&&57>=f){for(48==f&&(f=g.charCodeAt(v+1),f>=48&&57>=f)&&z();h>v&&(f=g.charCodeAt(v),f>=48&&57>=f);v++);if(46==g.charCodeAt(v)){for(d=++v;h>d&&(f=g.charCodeAt(d),f>=48&&57>=f);d++);d==v&&z(),v=d}if(f=g.charCodeAt(v),101==f||69==f){for(f=g.charCodeAt(++v),(43==f||45==f)&&v++,d=v;h>d&&(f=g.charCodeAt(d),f>=48&&57>=f);d++);d==v&&z(),v=d}return+g.slice(c,v)}if(e&&z(),"true"==g.slice(v,v+4))return v+=4,!0;if("false"==g.slice(v,v+5))return v+=5,!1;if("null"==g.slice(v,v+4))return v+=4,a;z()}return"$"},B=function(a){var b,c;if("$"==a&&z(),"string"==typeof a){if("@"==(m?a.charAt(0):a[0]))return a.slice(1);if("["==a){for(b=[];a=A(),"]"!=a;c||(c=!0))c&&(","==a?(a=A(),"]"==a&&z()):z()),","==a&&z(),b.push(B(a));return b}if("{"==a){for(b={};a=A(),"}"!=a;c||(c=!0))c&&(","==a?(a=A(),"}"==a&&z()):z()),(","==a||"string"!=typeof a||"@"!=(m?a.charAt(0):a[0])||":"!=A())&&z(),b[a.slice(1)]=B(A());return b}z()}return a},C=function(a,b,c){c=D(a,b,c),c===f?delete a[b]:a[b]=c},D=function(a,b,c){var d,f=a[b];if("object"==typeof f&&f)if("[object Array]"==g.call(f))for(d=f.length;d--;)C(f,d,c);else e(f,function(a){C(f,a,c)});return c.call(a,b,f)};j.parse=function(b,c){var d,e;return v=0,w=""+b,d=B(A()),"$"!=A()&&z(),v=w=a,c&&"[object Function]"==g.call(c)?D((e={},e[""]=d,e),"",c):d}}}h&&define(function(){return j})}(this)}();