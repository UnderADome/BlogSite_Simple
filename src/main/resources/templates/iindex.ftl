<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link href="res/img/html_head.png" rel="SHORTCUT ICON">
  <title>CODE的博客</title>
  <link rel="stylesheet" type="text/css" href="res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="res/css/main.css">
<!--加载meta IE兼容文件-->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
</head>
<body>
  <div class="header">
    <div class="menu-btn">
      <div class="menu"></div>
    </div>
    <h1 class="logo">
      <a href="index">
        <span>MYBLOG</span>
        <img src="res/img/logo.png">
      </a>
    </h1>
    <div class="nav">
      <a href="/" class="active">文章</a>
      <a href="whisper">微语</a>
      <a href="leacots">留言</a>
      <a href="album">相册</a>
      <a href="about">关于</a>
    </div>
    <ul class="layui-nav header-down-nav">
      <li class="layui-nav-item"><a href="/" class="active">文章</a></li>
      <li class="layui-nav-item"><a href="whisper">微语</a></li>
      <li class="layui-nav-item"><a href="leacots">留言</a></li>
      <li class="layui-nav-item"><a href="album">相册</a></li>
      <li class="layui-nav-item"><a href="about">关于</a></li>
    </ul>
    <p class="welcome-text">
      欢迎来到<span class="name">李韬</span>的博客~
    </p>
  </div>

  <div class="banner">
    <div class="cont w1000">
     <!--  <div class="title">
        <h3>欢迎来到<br />刘启旺</h3>
        <h4>博客空间</h4>
      </div> -->
      <!-- <div class="amount">
        <p><span class="text">访问量</span><span class="access">1000</span></p>
        <p><span class="text">日志</span><span class="daily-record">1000</span></p>
      </div> -->
    </div>
  </div>




  </div>
  <div class="content">
    <div class="cont w1000">
      <div class="title">
        <span class="layui-breadcrumb" id="layui-breadcrumb" lay-separator="|">
          <a href="javascript:;" class="active">最新文章</a>
          <a href="javascript:;">后台文章</a>
          <a href="javascript:;">旅游杂记</a>
        </span>
      </div>

      <div class="list-item" id="list-item">
          <#list articles as article>
          <div class="item", id="item">
              <div class="layui-fluid">
                  <div class="layui-row">
                      <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">
                          <div class="img"><img src=${article.pic} alt=""></div>
                      </div>
                      <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">
                          <div class="item-cont">
                              <h3>${article.title}, id=${article.id}<button class="layui-btn layui-btn-danger new-icon">new</button></h3>
                              <h5>${article.item}</h5>
                              <p>${article.article_content}</p>
                              <a href="/details?id=${article.id}" class="go-icon"></a>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          </#list>
      </div>

      <div id="demo" style="text-align: center;"></div>
    </div>
  </div>

  <div class="footer-wrap">
    <div class="footer w1000">
      <div class="qrcode">
        <img width="160px" src="res/img/wx.jpg">
      </div>
      <div class="practice-mode">
        <!-- <img src="res/img/down_img.jpg"> -->
        <div class="text">
          <h4 class="title">我的联系方式</h4>
		  <p>手机<span class="iphone">18651820052</span></p>
		  <p>Q&nbsp;Q<span class="email">478430357</span></p>
		  <p>邮箱<span class="email">478430357@qq.com</span></p>
        </div>
      </div>
    </div>
  </div>


  <script type="text/javascript" src="res/layui/layui.js"></script>
  <script type="text/javascript">
    layui.config({
      base: 'res/js/util/'
    }).use(['element','laypage','jquery','menu'],function(){
      element = layui.element,laypage = layui.laypage,$ = layui.$,menu = layui.menu;
      laypage.render({
          elem: 'demo'
          ,count: 70 //数据总数，从服务端得到
          ,page:true //开启分页
          ,jump:function(obj, first){
              if (!first){
                  var curr = obj.curr; //得到点击的页数
                  //异步获取数据，作更新页面操作
                  $.get("index?page="+curr
                          ,function (res) {
                              // data = res.result;
                              // console.log(res);
                              setHtml(res);
                          });
              }
          }
      });
      menu.init();
      //$.get("http://132.232.35.56:8088/APIHandler.ashx?method=api_ip_record");
        //$.get("http://127.0.0.1:8080/index?page=2")
    });

    function setHtml(data) {
        console.log("进入了设置函数");
        var strHtml = "";
        $.each(data, function(index, item){
            console.log("拼接字符串");
            strHtml +=
                    '          <div class="item">'+
                    '              <div class="layui-fluid">'+
                    '                  <div class="layui-row">' +
                    '                      <div class="layui-col-xs12 layui-col-sm4 layui-col-md5">' +
                    '                          <div class="img"><img src=' +item.pic+ ' alt=""></div>' +
                    '                      </div>' +
                    '                      <div class="layui-col-xs12 layui-col-sm8 layui-col-md7">' +
                    '                          <div class="item-cont">' +
                    '                              <h3>'+item.title+', id='+item.id+'<button class="layui-btn layui-btn-danger new-icon">new</button></h3>' +
                    '                              <h5>'+item.item+'</h5>' +
                    '                              <p>'+item.article_content+'</p>' +
                    '                              <a href='+'/details?id='+item.id+' '+'class="go-icon"></a>' +
                    '                          </div>' +
                    '                      </div>' +
                    '                  </div>' +
                    '              </div>' +
                    '          </div>';
            //console.log(strHtml);
        });
        //这一条一点用都没有
        //document.getElementsByClassName('list-item').innerHTML = strHtml;
        $('.item').remove();
        $('.list-item').append(strHtml);
    }

    //监听面包屑
    layui.use('element', function(){
        console.log("开始监听面包屑");
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        $ = layui.$;
        //监听导航点击
        // element.on('.layui-breadcrumb', function(elem){
        //     console("进入面包屑核心函数");
        //     console.log(elem+"1111111111111111111111111111111");
        //     //layer.msg(elem.text());
        // });

        //点击改变span下a的class
        $(".layui-breadcrumb a").on("mousedown", function(elem){
            console.log("点击"+elem.toString());
            console.log(this);
            //$(".layui-breadcrumb a").removeClass('active');
            //$(this).addClass('active');
            $(this).addClass("active").siblings("a").removeClass("active");
        });

    });
    //解决监听问题：https://my.oschina.net/u/1791116/blog/1791336
    //https://www.layui.com/v1/doc/modules/element.html
    //https://www.layui.com/demo/nav.html


  </script>

</body>
</html>