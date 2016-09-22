##Salt

Salt 是 PlantUML 下面的子项目用来帮助用户来设计图形接口.
可以用 @startsalt 关键字，或者使用 @startuml 紧接着下一行使用salt 关键字.

##基本部件


一个窗口必须以中括号开头和结尾。 接着可以这样定义:

- 按钮用 [ 和 ]。
- 单选按钮用 ( 和 )。
- 复选框用 [ 和 ]。
- 用户文字域用 "。

	@startuml
	salt
	{
	  Just plain text
	  [This is my button]
	  ()  Unchecked radio
	  (X) Checked radio
	  []  Unchecked box
	  [X] Checked box
	  "Enter text here   "
	  ^This is a droplist^
	}
	@enduml

这个工具是用来讨论简单的示例窗口。
使用表格

当在输入关键词 {后，会自动建立一个表格 
当输入| 说明一个单元格 
例子如下

	@startsalt
	{
	  Login    | "MyName   "
	  Password | "****     "
	  [Cancel] | [  OK   ]
	}
	@endsalt
	
	Just after the opening bracket, you can use a character to define if you want to draw lines or columns of the grid :
	#	To display all vertical and horizontal lines
	!	To display all vertical lines
	-	To display all horizontal lines
	+	To display external lines
	@startsalt
	{+
	  Login    | "MyName   "
	  Password | "****     "
	  [Cancel] | [  OK   ]
	}
	@endsalt

##Using separator

	You can use several horizontal lines as separator.
	
	@startsalt
	{
	  Text1
	  ..
	  "Some field"
	  ==
	  Note on usage
	  ~~
	  Another text
	  --
	  [Ok]
	}
	@endsalt

##Tree widget

To have a Tree, you have to start with {T and to use + to denote hierarchy.

	@startsalt
	{
	{T
	 + World
	 ++ America
	 +++ Canada
	 +++ USA
	 ++++ New York
	 ++++ Boston
	 +++ Mexico
	 ++ Europe
	 +++ Italy
	 +++ Germany
	 ++++ Berlin
	 ++ Africa
	}
	}
	@endsalt

##Enclosing brackets

You can define subelements by opening a new opening bracket.

	@startsalt
	{
	Name         | "                 "
	Modifiers:   | { (X) public | () default | () private | () protected
	                [] abstract | [] final   | [] static }
	Superclass:  | { "java.lang.Object " | [Browse...] }
	}
	@endsalt
		

##Adding tabs

You can add tabs using {/ notation. Note that you can use HTML code to have bold text.

	@startsalt
	{+
	{/ <b>General | Fullscreen | Behavior | Saving }
	{
		{ Open image in: | ^Smart Mode^ }
		[X] Smooth images when zoomed
		[X] Confirm image deletion
		[ ] Show hidden images
	}
	[Close]
	}
	@endsalt

Tab could also be vertically oriented:

	@startsalt
	{+
	{/ <b>General
	Fullscreen
	Behavior
	Saving } |
	{
		{ Open image in: | ^Smart Mode^ }
		[X] Smooth images when zoomed
		[X] Confirm image deletion
		[ ] Show hidden images 
		[Close]
	}
	}
	@endsalt

##Using menu

You can add a menu by using {* notation.

	@startsalt
	{+
	{* File | Edit | Source | Refactor }
	{/ General | Fullscreen | Behavior | Saving }
	{
		{ Open image in: | ^Smart Mode^ }
		[X] Smooth images when zoomed
		[X] Confirm image deletion
		[ ] Show hidden images 
	}
	[Close]
	}
	@endsalt

It is also possible to open a menu:

	@startsalt
	{+
	{* File | Edit | Source | Refactor 
	 Refactor | New | Open File | - | Close | Close All }
	{/ General | Fullscreen | Behavior | Saving }
	{
		{ Open image in: | ^Smart Mode^ }
		[X] Smooth images when zoomed
		[X] Confirm image deletion
		[ ] Show hidden images 
	}
	[Close]
	}
	@endsalt

##Advanced table

You can use two special notations for table :
* to indicate that a cell with span with left
. to denotate an empty cell

	@startsalt
	{#
	. | Column 2 | Column 3
	Row header 1 | value 1 | value 2
	Row header 2 | A long cell | *
	}
	@endsalt

##OpenIconic

OpenIconic is an very nice open source icon set. Those icons have been integrated into the creole parser, so you can use them out-of-the-box.
You can use the following syntax: <&ICON_NAME>.

	@startsalt
	{
	  Login<&person> | "MyName   "
	  Password<&key> | "****     "
	  [Cancel <&circle-x>] | [OK <&account-login>]
	}
	@endsalt

The complete list is available on OpenIconic Website, or you can use the following special diagram:

	@startuml
	listopeniconic
	@enduml
