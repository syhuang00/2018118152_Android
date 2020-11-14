####                                                           **实验四 Intent应用**

**实验要求**：学习掌握Intent应用

**实验目的**：Intent是Android程序中各组件之间进行交互的一种重要方式，它不仅可以指明当前组件想要执行的动作，还可以在不同组件之间传递数据。

**实验内容**：

Intent大致可以分为两种，显示Intent和隐式Intent。在显式Intent中，Intent有多个构造函数的重载，其中一个是Intent(Context packageContext,Class<?> cls)这个构造函数接受两个参数，第一个参数Context要求提供一个启动活动的上下文，第二个参数Class则是指定想要启动的目标活动。

因此，我们创建一个Intent，传入FirstActivity.this作为上下文，传入SecondActivity.class作为目标活动，这样我们的“意图”就很明显，在FirstActivity活动的基础上打开SecondActivity，然后通过startActivity()方法来执行这个Intent。

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%9B%9B%20Intent%E5%BA%94%E7%94%A8/Intent%E5%BA%94%E7%94%A8%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/Intent01.png)

隐式Intent并不明确指出我们想要哪一个活动，而是指定了一系列更为抽象的action和category等信息，然后交由系统去分析这个Intent，并帮我们找出合适的方法去启动。在<action>标签中我们指明了当前活动可以响应什么action，而<category>标签则包含了一些附加信息，更加明确地指明了当前的活动能够响应的Intent中还可能带有的category。只有<action>和<category>中的内容同时能够匹配上Intent中指定的action和 category，这个活动才能响应该Intent。

自定义的 Intent 的使用：

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%9B%9B%20Intent%E5%BA%94%E7%94%A8/Intent%E5%BA%94%E7%94%A8%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/Intent02.png)

在这里android.intent.category.DEFAULT是一种默认的category，在调用startActivity()方法时会自动将这个category添加到Intent中。

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%9B%9B%20Intent%E5%BA%94%E7%94%A8/Intent%E5%BA%94%E7%94%A8%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/Intent03.png)

此时在FirstActivity的界面点击按钮，能成功启动SecondActivity。

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%9B%9B%20Intent%E5%BA%94%E7%94%A8/Intent%E5%BA%94%E7%94%A8%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/Intent04.png)

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%9B%9B%20Intent%E5%BA%94%E7%94%A8/Intent%E5%BA%94%E7%94%A8%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/Intent05.png)

系统内置隐含 Intent的使用：

使用隐式Intent时，我们不仅可以使用自己程序内的活动，还可以启动其他程序的活动，使得多个应用程序之间的功能共享成为了可能。比如打开网页，只需要调用系统的浏览器来打开这个网页就行了。

Intent.ACTION_VIEW是一个Android系统的内置动作。然后通过Uri.parse()方法将一个网址字符串解析成一个Uri对象，再调用Intent的setData()方法将这个Uri对象传递进去。

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%9B%9B%20Intent%E5%BA%94%E7%94%A8/Intent%E5%BA%94%E7%94%A8%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/Intent06.png)

此时在SecondActivity的界面点击按钮，会启动系统浏览器界面。

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%9B%9B%20Intent%E5%BA%94%E7%94%A8/Intent%E5%BA%94%E7%94%A8%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/Intent07.png)

**实验总结**：

评价：本次实验达到了实验目标，学习掌握了Intent的应用，特别是系统内置隐含 Intent和自定义的 Intent 的使用。

心得收获：

Intent一般可以被用于启动活动，启动服务以及发生广播等场景。