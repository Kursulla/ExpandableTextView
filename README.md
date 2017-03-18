# ExpandableTextView

_small View variation that enable you to limit text int view and offer "ReadMore button"._

----

Usage is simple. Just, in your layout XML, use ExpandableTextView view with appropriate attributes:


```Java 
<com.eutechpro.expandabletextview.ExpandableTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:text="@string/some_text"
        custom:expand_label="@string/load_more"
        custom:collapse_label="@string/collapse"
        custom:limit="200"
        />
```


Attributes:


- **text**: 			text content of your TextView (text or string resource)
- **expand_label**: 	label of "button" that will expand text (text or string resource)
- **colapse_label**: 	label of "button" that will collapse text (text or string resource)
- **limit**: 			amount of characters to "break" content text on

> Do not forget to use custom namespace:
__xmlns:custom="http://schemas.android.com/apk/res-auto"__  






    
    
__If you do not set "_collapse_label_", after expanding, there will be no collapse button.__



For gradient effect under "_LoadMore_" 

![alt tag](https://dl.dropboxusercontent.com/s/80x97zzwrbmh835/gradient.png?dl=0   width="300px")

feel free to edit drawable file: "__bottom_up_transparent_gradient.xml__"


Expanding/Collapsing:

![alt tag](https://dl.dropboxusercontent.com/s/6kq8soih5fchph9/collapsable_video.gif?dl=0   width="48")




# Roadmap


- Add someting like "OnCollapsedListener"


