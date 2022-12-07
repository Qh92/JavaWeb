# Servlet

# 1.Servlet

## a)什么是 Servlet 

1、Servlet 是 JavaEE 规范之一。规范就是接口 

2、Servlet 就 JavaWeb 三大组件之一。三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器。 

3、Servlet 是运行在服务器上的一个 java 小程序，它可以接收客户端发送过来的请求，并响应数据给客户端。 

## b)手动实现 Servlet 程序 

1、编写一个类去实现 Servlet 接口 

2、实现 service 方法，处理请求，并响应数据 

3、到 web.xml 中去配置 servlet 程序的访问地址 

### Servlet 程序的示例代码：

```java
public class HelloServlet implements Servlet { 
    /**
    service 方法是专门用来处理请求和响应的
    */
    @Override public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException { 
        System.out.println("Hello Servlet 被访问了"); 
    }
}
```

### web.xml 中的配置：

```xml
<?xml version="1.0" encoding="UTF-8"?> 
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" version="4.0"> 
    <!-- servlet 标签给 Tomcat 配置 Servlet 程序 --> 
    <servlet> 
        <!--servlet-name 标签 Servlet 程序起一个别名（一般是类名） --> 
        <servlet-name>HelloServlet</servlet-name> 
        <!--servlet-class 是 Servlet 程序的全类名--> 
        <servlet-class>com.atguigu.servlet.HelloServlet</servlet-class> 
    </servlet> 
    <!--servlet-mapping 标签给 servlet 程序配置访问地址--> 
    <servlet-mapping> 
        <!--servlet-name 标签的作用是告诉服务器，我当前配置的地址给哪个 Servlet 程序使用--> 
        <servlet-name>HelloServlet</servlet-name> 
        <!--url-pattern 标签配置访问地址 <br/> / 斜杠在服务器解析的时候，表示地址为：http://ip:port/工程路径 <br/> /hello 表示地址为：http://ip:port/工程路径/hello <br/> --> 
        <url-pattern>/hello</url-pattern> 
    </servlet-mapping> 
</web-app>
```

### 常见的错误 1：url-pattern 中配置的路径没有以斜杠打头

![1619144386664](assets\1619144386664.png)

### 常见错误 2：servlet-name 配置的值不存在：

![1619144437008](assets\1619144437008.png)

### 常见错误 3：servlet-class 标签的全类名配置错误：

![1619144479822](assets\1619144479822.png)



## c)url 地址到 Servlet 程序的访问

![1619144553508](assets\1619144553508.png)



## d)Servlet 的生命周期

1、执行 Servlet 构造器方法 

2、执行 init 初始化方法 

第一、二步，是在第一次访问的时候创建 Servlet 程序会调用。 

3、执行 service 方法 

第三步，每次访问都会调用。 

4、执行 destroy 销毁方法 

第四步，在 web 工程停止的时候调用。



## e)GET 和 POST 请求的分发处理

```java
public class HelloServlet implements Servlet {
    /** 
     * service 方法是专门用来处理请求和响应的 
     * @param servletRequest 
     * @param servletResponse 
     * @throws ServletException 
     * @throws IOException 
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === Hello Servlet 被访问了");
        // 类型转换（因为它有 getMethod()方法） 
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest; 
        // 获取请求的方式 
        String method = httpServletRequest.getMethod(); 
        if ("GET".equals(method)) { 
            doGet(); 
        } 
        else if ("POST".equals(method)) { 
            doPost(); 
        } 
    }
    /**
     * 做 get 请求的操作 
     */ 
    public void doGet(){ 
        System.out.println("get 请求"); 
        System.out.println("get 请求"); 
    }
    /**
     * 做 post 请求的操作 
     */ 
    public void doPost(){ 
        System.out.println("post 请求"); 
        System.out.println("post 请求"); 
    } 
}
```



## f) 通过继承 HttpServlet 实现 Servlet 程序

一般在实际项目开发中，都是使用继承 HttpServlet 类的方式去实现 Servlet 程序。 

1、编写一个类去继承 HttpServlet 类 

2、根据业务需要重写 doGet 或 doPost 方法 

3、到 web.xml 中的配置 Servlet 程序的访问地址



### Servlet 类的代码：

```java
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //不加super.init(config);会出现异常
        super.init(config);
        System.out.println("初始化工作......");
        //3.获取ServletContext对象
        System.out.println("获取ServletContext对象: " + config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doGet方法");
        //也可以使用
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        System.out.println("初始化参数username的值是: " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是: " + servletConfig.getInitParameter("url"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost方法");
    }
}
```

### web.xml 中的配置：

```xml
<servlet>
    <servlet-name>HelloServlet2</servlet-name>
    <servlet-class>com.qinh.HelloServlet2</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>HelloServlet2</servlet-name>
    <url-pattern>/hello2</url-pattern>
</servlet-mapping>
```



## g)使用 IDEA 创建 Servlet 程序

### 菜单：new ->Servlet 程序 

![1619145236487](assets\1619145236487.png)



### 配置 Servlet 的信息：

![1619145282629](assets\1619145282629.png)



## h)Servlet 类的继承体系 

![1619145324882](assets\1619145324882.png)



# 2.ServletConfig 类

ServletConfig 类从类名上来看，就知道是 Servlet 程序的配置信息类。 

Servlet 程序和 ServletConfig 对象都是由 Tomcat 负责创建，我们负责使用。 

Servlet 程序默认是第一次访问的时候创建，ServletConfig 是每个 Servlet 程序创建时，就创建一个对应的 ServletConfig 对象。



## a)ServletConfig 类的三大作用 

1、可以获取 Servlet 程序的别名 servlet-name 的值 

2、获取初始化参数 init-param 

3、获取 ServletContext 对象

### web.xml 中的配置：

```xml
<!-- servlet标签给Tomcat配置Servlet程序-->
    <servlet>
        <!-- servlet-name标签 Servlet程序起一个别名（一般类名）-->
        <servlet-name>HelloServlet</servlet-name>
        <!-- servlet-class是Servlet程序的全类名-->
        <servlet-class>com.qinh.HelloServlet</servlet-class>
        <!-- init-param是初始化参数 -->
        <init-param>
            <!-- 参数名 -->
            <param-name>username</param-name>
            <!-- 参数值 -->
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <!-- 参数名 -->
            <param-name>url</param-name>
            <!-- 参数值 -->
            <param-value>jdbc:mysql://localhost:3306/test</param-value>
        </init-param>
    </servlet>

    <!-- servlet-mapping标签给servlet程序配置访问地址-->
    <servlet-mapping>
        <!-- servlet-name标签的作用是告诉服务器，当前配置的地址给哪个Servlet程序使用-->
        <servlet-name>HelloServlet</servlet-name>
        <!-- url=pattern标签配置访问地址 <br/>
            / 斜杠在服务器解析的时候，表示地址为: http://ip:port/工程路径   <br/>
            /hello 表示地址为：http://ip:port/工程路径/hello   <br/>
        -->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```



### Servlet 中的代码：

```java
public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init方法");

        //1.可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是: " + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("初始化参数username的值是: " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是: " + servletConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println("获取ServletContext对象: " + servletConfig.getServletContext());
    }
```

### 注意点：

![1619145650894](assets\1619145650894.png)



# 3.ServletContext 类



## a)什么是 ServletContext? 

1、ServletContext 是一个接口，它表示 Servlet 上下文对象 

2、一个 web 工程，只有一个 ServletContext 对象实例。 

3、ServletContext 对象是一个域对象。 

4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。 



什么是域对象? 

域对象，是可以像 Map 一样存取数据的对象，叫域对象。 

这里的域指的是存取数据的操作范围，整个 web 工程。 

![1619145739101](assets\1619145739101.png)



## b)ServletContext 类的四个作用

1、获取 web.xml 中配置的上下文参数 context-param 

2、获取当前的工程路径，格式: /工程路径 

3、获取工程部署后在服务器硬盘上的绝对路径 

4、像 Map 一样存取数据



### ServletContext 演示代码：

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        //1、获取web.xml中配置的上下文参数context-param
        String username = context.getInitParameter("username");
        // root
        System.out.println(username);
        String url = context.getInitParameter("url");
        // jdbc:mysql://localhost:3306/test
        System.out.println(url);

        //2、获取当前的工程路径，格式: /工程路径
        String contextPath = context.getContextPath();
        // /servlet
        System.out.println(contextPath);

        //3、获取工程部署后在服务器硬盘上的绝对路径
        /**
         *  / 斜杠被服务器解析地址为:http://ip:port/工程名/  映射到IDEA代码的web目录<br/>
         */
        // E:\item\JavaWeb\JavaWeb\out\artifacts\
        System.out.println("工程部署的路径是:" + context.getRealPath("/"));
        System.out.println("工程下css目录的绝对路径是:" + context.getRealPath("/css"));
        System.out.println("工程下imgs目录1.jpg的绝对路径是:" + context.getRealPath("/imgs/1.jpg"));
    }
```

web.xml 中的配置：

```xml
	<!--context-param 是上下文参数(它属于整个 web 工程)-->
    <context-param>
        <param-name>username</param-name>
        <param-value>root</param-value>
    </context-param>
    <!--context-param 是上下文参数(它属于整个 web 工程)-->
    <context-param>
        <param-name>password</param-name>
        <param-value>root</param-value>
    </context-param>
    <context-param>
        <param-name>url</param-name>
        <param-value>jdbc:mysql://localhost:3306/test</param-value>
    </context-param>
```

ServletContext 像 Map 一样存取数据： 

ContextServlet1 代码：

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("保存之前: Context1 获取 key1的值是:"+ context.getAttribute("key1"));

        context.setAttribute("key1","value1");

        System.out.println("Context1 中获取域数据key1的值是:"+ context.getAttribute("key1"));
    }
```

ContextServlet2 代码：

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("Context2 中获取域数据key1的值是:"+ context.getAttribute("key1"));
    }
```



# 4.HTTP 协议 



## a)什么是 HTTP 协议 

什么是协议? 

协议是指双方，或多方，相互约定好，大家都需要遵守的规则，叫协议。 

所谓 HTTP 协议，就是指，客户端和服务器之间通信时，发送的数据，需要遵守的规则，叫 HTTP 协议。 

HTTP 协议中的数据又叫报文。

## b)请求的 HTTP 协议格式 

客户端给服务器发送数据叫请求。 

服务器给客户端回传数据叫响应。 

### 请求又分为 GET 请求，和 POST 请求两种 

#### i. GET 请求 

##### 1、请求行 

(1) 请求的方式      GET 

(2) 请求的资源路径[+?+请求参数] 

(3) 请求的协议的版本号    HTTP/1.1 

##### 2、请求头

key : value 组成不同的键值对，表示不同的含义。

![1619147210823](assets\1619147210823.png)



#### ii. POST 请求

##### 1、请求行

(1) 请求的方式   POST 

(2) 请求的资源路径[+?+请求参数] 

(3) 请求的协议的版本号   HTTP/1.1 

##### 2、请求头

1) key : value 不同的请求头，有不同的含义

 空行 

##### 3、请求体 ===>>> 就是发送给服务器的数据

![1619147345928](assets\1619147345928.png)



#### iii. 常用请求头的说明

Accept: 表示客户端可以接收的数据类型 

Accpet-Languege: 表示客户端可以接收的语言类型 

User-Agent: 表示客户端浏览器的信息 

Host： 表示请求时的服务器 ip 和端口号

#### iv. 哪些是 GET 请求，哪些是 POST 请求

GET 请求有哪些： 

1、form 标签 method=get 

2、a 标签 

3、link 标签引入 css 

4、Script 标签引入 js 文件 

5、img 标签引入图片 

6、iframe 引入 html 页面 

7、在浏览器地址栏中输入地址后敲回车 

POST 请求有哪些： 

8、form 标签 method=post



## c)响应的 HTTP 协议格式

##### 1、响应行 

(1) 响应的协议和版本号 

(2) 响应状态码 

(3) 响应状态描述符 

##### 2、响应头 

(1) key : value 不同的响应头，有其不同含义 

空行 

##### 3、响应体 ---->>> 就是回传给客户端的数据

![1619147479554](assets\1619147479554.png)

## d)常用的响应码说明

200  表示请求成功 

302 表示请求重定向 

404 表示请求服务器已经收到了，但是你要的数据不存在（请求地址错误） 

500 表示服务器已经收到请求，但是服务器内部错误（代码错误） 



## e)MIME 类型说明

MIME 是 HTTP 协议中数据类型。 

MIME 的英文全称是"Multipurpose Internet Mail Extensions" 多功能 Internet 邮件扩充服务。MIME 类型的格式是“大类型/小类型”，并与某一种文件的扩展名相对应。 

常见的 MIME 类型： 

![1619147639053](assets\1619147639053.png)



 ![1619147655617](assets\1619147655617.png)                      

![1619147703665](assets\1619147703665.png)



火狐浏览器如何查看 HTTP 协议：

![1619147750518](assets\1619147750518.png)





# 5.HttpServletRequest 类



## a)HttpServletRequest 类有什么作用

每次只要有请求进入 Tomcat 服务器，Tomcat 服务器就会把请求过来的 HTTP 协议信息解析好封装到 Request 对象中。 

然后传递到 service 方法（doGet 和 doPost）中给我们使用。我们可以通过 HttpServletRequest 对象，获取到所有请求的 

信息。



## b)HttpServletRequest 类的常用方法



i. getRequestURI()                         获取请求的资源路径 

ii. getRequestURL()                       获取请求的统一资源定位符（绝对路径） 

iii. getRemoteHost()                       获取客户端的 ip 地址 

iv. getHeader()                               获取请求头 

v. getParameter()                           获取请求的参数 

vi. getParameterValues()               获取请求的参数（多个值的时候使用） 

vii. getMethod()                              获取请求的方式 GET 或 POST 

viii. setAttribute(key, value);           设置域数据 

ix. getAttribute(key);                       获取域数据 

x. getRequestDispatcher()             获取请求转发对象

### 常用 API 示例代码： 

```java
public class RequestAPIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        i.getRequestURI()					获取请求的资源路径
        System.out.println("请求资源路径 : " + request.getRequestURI());
//        ii.getRequestURL()					获取请求的统一资源定位符（绝对路径）
        System.out.println("请求的统一资源定位符 : " + request.getRequestURL());
//        iii.getRemoteHost()				获取客户端的ip地址
        /**
         * 在IDEA中，使用localhost访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用127.0.0.1访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1<br/>
         * 在IDEA中，使用 真实ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址<br/>
         */
        System.out.println("客户端的ip地址 : " + request.getRemoteHost());
//        iv.getHeader()						获取请求头
        System.out.println("请求头 : " + request.getHeader("User-Agent"));
//        vii.getMethod()					获取请求的方式GET或POST
        System.out.println("请求方式 : " + request.getMethod());
    }
}
```



## c)如何获取请求参数

表单：

```xml
<form action="http://localhost:8080/servlet2/servlet1" method="get">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        兴趣爱好：<input type="checkbox" name="hobby" value="cpp">C++
        <input type="checkbox" name="hobby" value="java">Java
        <input type="checkbox" name="hobby" value="js">JavaScript<br/>
        <input type="submit">
    </form>
```

Java 代码：

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------doGet------------");

        // 获取请求参数
        String username = request.getParameter("username");
        //1 先以iso8859-1进行编码
        //2 再以utf-8进行解码
        //username = new String(username.getBytes("iso-8859-1"), "UTF-8");

        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }
```

doGet 请求的中文乱码解决：

```java
//1 先以iso8859-1进行编码
//2 再以utf-8进行解码
//username = new String(username.getBytes("iso-8859-1"), "UTF-8");
```



## d)POST 请求的中文乱码解决

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-------------doPost------------");
        // 设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        // 也要在获取请求参数之前调用才有效
        request.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }
```



## e)请求的转发

什么是请求的转发? 请求转发是指，服务器收到请求后，从一次资源跳转到另一个资源的操作叫请求转发

![1619163419810](assets\1619163419810.png)





### Servlet1 代码：

```java
public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数（办事的材料）查看
        String username = request.getParameter("username");
        System.out.println("在Servlet1（柜台1）中查看参数（材料）：" + username);

        // 给材料 盖一个章，并传递到Servlet2（柜台 2）去查看
        request.setAttribute("key1","柜台1的章");

        // 问路：Servlet2（柜台 2）怎么走
        /**
         * 请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/ , 映射到IDEA代码的web目录<br/>
         *
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com");

        // 走向Sevlet2（柜台 2）
        requestDispatcher.forward(request,response);
    }
}
```



### Servlet2 代码：

```java
public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数（办事的材料）查看
        String username = request.getParameter("username");
        System.out.println("在Servlet2（柜台2）中查看参数（材料）：" + username);

        // 查看 柜台1 是否有盖章
        Object key1 = request.getAttribute("key1");
        System.out.println("柜台1是否有章：" + key1);

        // 处理自己的业务
        System.out.println("Servlet2 处理自己的业务 ");
    }
}
```



## **f) base** 标签的作用

![image-20210425001533726](assets\image-20210425001533726.png)



```xml
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--base标签设置页面相对路径工作时参照的地址
            href 属性就是参数的地址值
    -->
    <base href="http://localhost:8080/servlet2/a/b/">
</head>
<body>
    这是a下的b下的c.html页面<br/>
    <a href="../../index.html">跳回首页</a><br/>
</body>
</html>
```



## **g)Web** 中的相对路径和绝对路径



在 javaWeb 中，路径分为相对路径和绝对路径两种： 

相对路径是： 

	.              表示当前目录 
	
	..             表示上一级目录 
	
	资源名    表示当前目录/资源名 

绝对路径： 

http://ip:port/工程路径/资源路径 

在实际开发中，路径都使用绝对路径，而不简单的使用相对路径。 

1、绝对路径 

2、base+相对 



## **h)web** **中** **/** 斜杠的不同意义

在 web 中 / 斜杠 是一种绝对路径。 

/  斜杠   如果被浏览器解析，得到的地址是：http://ip:port/ 

```xml
<a href="/">斜杠</a>
```



/   斜杠    如果被服务器解析，得到的地址是：http://ip:port/工程路径 

1、<**url-pattern**>/servlet1</**url-pattern**> 

2、servletContext.getRealPath(“/”); 

3、request.getRequestDispatcher(“/”); 

特殊情况： response.sendRediect(“/”); 把斜杠发送给浏览器解析。得到 http://ip:port/



# 6.HttpServletResponse类



## a)HttpServletResponse类的作用

HttpServletResponse 类和 HttpServletRequest 类一样。每次请求进来，Tomcat 服务器都会创建一个 Response 对象传 递给 Servlet 程序去使用。HttpServletRequest 表示请求过来的信息，HttpServletResponse 表示所有响应的信息， 我们如果需要设置返回给客户端的信息，都可以通过 HttpServletResponse 对象来进行设置



## b)两个输出流的说明

字节流   getOutputStream(); 常用于下载（传递二进制数据） 

字符流   getWriter();              常用于回传字符串（常用） 

两个流同时只能使用一个。 使用了字节流，就不能再使用字符流，反之亦然，否则就会报错。 

![image-20210425002611064](assets\image-20210425002611064.png)



## c)如何往客户端回传数据

### 要求 ： 往客户端回传 字符串 数据。

```java
public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ISO-8859-1
        System.out.println(resp.getCharacterEncoding());

        // 设置服务器字符集为UTF-8
        //resp.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也使用UTF-8字符集
        //resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        // 它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=UTF-8");

        //要求 ： 往客户端回传 字符串 数据。
        PrintWriter writer = resp.getWriter();
        writer.write("这是一个测试");
    }
}
```



## d)响应的乱码解决

### 解决响应中文乱码方案一（不推荐使用）： 

```java
// 设置服务器字符集为UTF-8
//resp.setCharacterEncoding("UTF-8");
// 通过响应头，设置浏览器也使用UTF-8字符集
//resp.setHeader("Content-Type", "text/html; charset=UTF-8");
```



### 解决响应中文乱码方案二（推荐）：

```java
// 它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
// 此方法一定要在获取流对象之前调用才有效
resp.setContentType("text/html; charset=UTF-8");
```



## e)请求重定向

请求重定向，是指客户端给服务器发请求，然后服务器告诉客户端说。我给你一些地址。你去新地址访问。叫请求 重定向（因为之前的地址可能已经被废弃）。 

![image-20210425003013119](assets\image-20210425003013119.png)



请求重定向的第一种方案： 

```java
// 设置响应状态码 302 ，表示重定向，（已搬迁） 
resp.setStatus(302); 
// 设置响应头，说明 新的地址在哪里 
resp.setHeader("Location", "http://localhost:8080");
```

请求重定向的第二种方案（推荐使用）： 

```java
resp.sendRedirect("http://localhost:8080");
```

