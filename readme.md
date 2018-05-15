SpringBoot-Websocket
    1.配置启动WebSocket类
        a.创建WebSocketConfigurer的实现类
        b.通过增加@EnableWebSocket注解启动WebSocket
    2.为配置类添加消息处理类
        a.创建消息处理类，该类继承AbstractWebSocketHandler或TextWebSocketHandler
            或BinaryWebSocketHandler，并重写其handleTextMessage，对文本消息进行处理，
            如果处理其它类型的消息可以重写其它方法。
        b.将消息处理方法注册到配之类方法重写的registerWebSocketHandlers方法中
            并设置接收的路径。注意是接收消息的路径，如果有返回消息会按原路径返回（即返回到发送端）
    3.页面通过js脚本指定目的地向服务端发送消息
        代码示例： <script type="text/javascript">
                     var url='ws://'+window.location.host+'/mes';
                     var sock=new WebSocket(url);
                     sock.onopen=function () {
                         console.log('Opening');
                         sayMes();
                     };
                     sock.onmessage=function (e) {
                         console.log("received message: "+e.data)
                         setTimeout(function () {
                             sayMes();
                         },2000);
                     };
                     sock.onclose=function () { console.log("sending message") };
                     function sayMes() {
                         console.log("sending message!");
                         sock.send("Hello new friend.");
                     }
                 </script>
                 
启用SockJS,解决浏览器不支持WebSocket功能
        a.在registerWebSocketHandlers方法中添加withSockJS();
        b.在页面中添加SockJS库
        c.修改页面代码，不再使用new WebSocket,而是使用new SockJS.
        
关于SpringBoot中静态资源的调用
    1.先判断是否使用了@EnableWebMvc注解
        如果没使用，就可以将资源文件放置在resources文件夹下，只要你启用了springboot，它会自动搜索
    2.如果启用了@EnableWebMvc注解，同时继承的是WebMvcConfigurerAdapter类，就需要如下配置，不然静态资源会被springmvc过滤掉
        a.通过configureDefaultServletHandling方法启动支持静态变量
        b.通过addResourceHandlers方法添加资源处理器
      注意：一旦启用了@EnableWebMvc注解，静态资源要放置在webapp目录下，不能放在
            resources目录下。
    3.如果继承的是WebMvcConfigurationSupport类就不能使用@EnableWebMvc注解了，
      不然configureDefaultServletHandling方法和addResourceHandlers方法都无效
      因为在WebMvcConfigurationSupport类中实现了上述两个方法，所以一般情况下不需要重写了，除非需要指定非默认路径，
      一旦使用@EnableWebMvc注解，父类的方法会被覆盖。一般来说都使用WebMvcConfigurationSupport类，
      WebMvcConfigurerAdapter类被弃用了
    3.客户端使用该静态资源
        <script th:src="@{/js/sockjs.min.js}"></script>
            其中/js/sockjs.min.js指的是webapp目录下的资源  
                 
使用webjars实现静态资源管理
        1.引入相应的jar包依赖
            相关的jar包可以到webjars官网查找
        2.判断是否使用了@EnableWebMvc注解，同时继承的是WebMvcConfigurerAdapter类；
            或者继承了WebMvcConfigurationSupport类。
            需要在addResourceHandlers方法添加如下配置
            //使用webjars的配置
            registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        3.在客户端中使用该静态资源 如下
            <script src="/webjars/sockjs-client/1.1.4/dist/sockjs.js"></script>
            其中sockjs-client对应<artifactId>，1.1.4为版本号，其余的可以根据jar包
            的目录结构进行查找，直到找到资源文件，通过ctrl+鼠标右击，如果能访问到资源文件说明路径对了

通过http url路径访问资源文件
        最简单的方式