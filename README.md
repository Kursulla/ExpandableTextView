##ExpandableTextView
_small TextView variation that enable you to limit text int textview and offer "ReadMore" button._

----

Usage is simple. Just, in your layout XML, use ExpandableTextView view with appropriate attributes:

'''

	 <com.eutechpro.expandabletextview.ExpandableTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custom:text="@string/some_text"
        custom:expand_label="@string/load_more"
        custom:collapse_label="@string/collapse"
        custom:limit="200"
        />
'''


Attributes:


- **text**: 			text content of your TextView (text or string resource)
- **expand_label**: 	label of "button" that will expand text (text or string resource)
- **colapse_label**: 	label of "button" that will collapse text (text or string resource)
- **limit**: 			amount of characters to "break" content text on

> Do not forget to use custom namespace:
__xmlns:custom="http://schemas.android.com/apk/res-auto"__


If you do not set "_collapse_label_", after expanding, there will be no collapse button.

For gradient effect bellow "_LoadMore_" feel free to edit drawable file: "__bottom_up_transparent_gradient.xml__"