                                                                         **实验六 RecyclerView**

**实验要求**：学习强大的滚动控件RecyclerView，了解他的方法和作用。

**实验目标**：使用 RecyclerView展示水果图片和文本，点击下方文本后，能够修改文本内容并显示出来。

**实验内容**：

当前界面，显示了水果的图片和文本

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%85%AD%20RecyclerView/RecyclerView%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010131.jpg)

点击文本或图片后会弹出显示点击了这个文本内容

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%85%AD%20RecyclerView/RecyclerView%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010132.jpg)

点击文本框会显示是否更改文本内容的对话框

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%85%AD%20RecyclerView/RecyclerView%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010133.jpg)

修改后文本就会变成用户输入的文本文字（如下图），并显示更改成功

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%85%AD%20RecyclerView/RecyclerView%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010134.jpg)

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%85%AD%20RecyclerView/RecyclerView%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010135.jpg)

此时再此点击图片或者文本时，将会显示用户更改后的文本文字

![Image](https://github.com/syhuang00/2018118152_Android/raw/master/%E5%AE%9E%E9%AA%8C%E5%85%AD%20RecyclerView/RecyclerView%E7%9A%84%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/2010136.jpg)

**实验总结**：

评价：通过本次实验，了解了RecyclerView的使用方法。

心得收获：

Android 提供了一个强大的滚动控件RecyclerView，它可以说是一个增强版的ListView，不仅可以轻松实现和ListView同样的效果，还优化了ListView中存在的各种不足之处。比如实现横向滚动。

RecyclerView必须要响应点击事件，但是RecyclerView没有提供类似于setOnItemClickListener()这样的注册监听器方法，而是需要我们自己给子项具体的View去注册点击事件。