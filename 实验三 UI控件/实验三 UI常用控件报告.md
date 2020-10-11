**实验三 UI控件**

android:id给Android的控件定义了一个唯一标识符。

android:layout_width，android:layout_height指定了控件的宽度和高度。Android中的所有控件都具有这两个属性。可选值有三种：match_parent，fill_parent，wrap_content。

TextView主要用于Android在界面显示一段信息，可以对其进行布局，颜色，大小，背景样式的修改，如以下代码：

![image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E4%B8%89%20UI%E6%8E%A7%E4%BB%B6/UI%E7%95%8C%E9%9D%A2%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010111.png)

EditText是程序用于用户进行交互的一个重要的组件，它允许用户在控件中输入和编辑内容，并可以在程序中对内容进行处理。可以和按钮一起使用。如以下代码：

![image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E4%B8%89%20UI%E6%8E%A7%E4%BB%B6/UI%E7%95%8C%E9%9D%A2%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010112.png)

Button是程序用于用户进行交互的另一个重要的组件，如以下代码：

![image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E4%B8%89%20UI%E6%8E%A7%E4%BB%B6/UI%E7%95%8C%E9%9D%A2%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010113.png)

然后可以在MainActivity中为Button的点击事件注册一个监听器，可添加逻辑，这样点击按钮时，就会响应监听器中的onClick()方法

![image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E4%B8%89%20UI%E6%8E%A7%E4%BB%B6/UI%E7%95%8C%E9%9D%A2%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010114.png)

ImageView是用于在界面上展示图片的一个控件，例如准备两张图片，通过代码动态地更改ImageView中的图片。