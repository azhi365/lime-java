##状态图

##简单状态

使用(\texttt[*])开始和结束状态图。
使用-->添加箭头。

	@startuml
	
	[*] --> State1
	State1 --> [*]
	State1 : this is a string
	State1 : this is another string
	
	State1 -> State2
	State2 --> [*]
	
	@enduml

##合成状态

一个状态也可能是合成的，必须使用关键字state和花括号来定义合成状态。

	@startuml
	scale 350 width
	[*] --> NotShooting
	
	state NotShooting {
	  [*] --> Idle
	  Idle --> Configuring : EvConfig
	  Configuring --> Idle : EvConfig
	}
	
	state Configuring {
	  [*] --> NewValueSelection
	  NewValueSelection --> NewValuePreview : EvNewValue
	  NewValuePreview --> NewValueSelection : EvNewValueRejected
	  NewValuePreview --> NewValueSelection : EvNewValueSaved
	  
	  state NewValuePreview {
	     State1 -> State2
	  }
	  
	}
	@enduml

##长名字

也可以使用关键字state定义长名字状态。

	@startuml
	scale 600 width
	
	[*] -> State1
	State1 --> State2 : Succeeded
	State1 --> [*] : Aborted
	State2 --> State3 : Succeeded
	State2 --> [*] : Aborted
	state State3 {
	  state "Accumulate Enough Data\nLong State Name" as long1
	  long1 : Just a test
	  [*] --> long1
	  long1 --> long1 : New Data
	  long1 --> ProcessData : Enough Data
	}
	State3 --> State3 : Failed
	State3 --> [*] : Succeeded / Save Result
	State3 --> [*] : Aborted
	 
	@enduml

##并发状态

用--作为分隔符来合成并发状态。
	@startuml
	[*] --> Active
	
	state Active {
	  [*] -> NumLockOff
	  NumLockOff --> NumLockOn : EvNumLockPressed
	  NumLockOn --> NumLockOff : EvNumLockPressed
	  --
	  [*] -> CapsLockOff
	  CapsLockOff --> CapsLockOn : EvCapsLockPressed
	  CapsLockOn --> CapsLockOff : EvCapsLockPressed
	  --
	  [*] -> ScrollLockOff
	  ScrollLockOff --> ScrollLockOn : EvCapsLockPressed
	  ScrollLockOn --> ScrollLockOff : EvCapsLockPressed
	}
	
	@enduml

##箭头方向

使用->定义水平箭头，也可以使用下列格式强制设置箭头方向：
- -down-> (default arrow)
- -right-> or ->
- -left->
- -up->

		@startuml
		
		[*] -up-> First
		First -right-> Second
		Second --> Third
		Third -left-> Last
		
		@enduml

可以用首字母缩写或者开始的两个字母定义方向(如, -d-，-down-和-do-是完全等价的)。
请不要滥用这些功能，Graphviz不喜欢这样。

##注释

可以用 note left of, note right of, note top of, note bottom of 关键字来定义注释。
还可以定义多行注释。

	@startuml
	
	[*] --> Active
	Active --> Inactive
	
	note left of Active : this is a short\nnote
	
	note right of Inactive
	  A note can also
	  be defined on
	  several lines
	end note
	
	@enduml

以及浮动注释。

	@startuml
	
	state foo
	note "This is a floating note" as N1
	
	@enduml

##更多注释

可以在合成状态中放置注释。

	@startuml
	
	[*] --> NotShooting
	
	state "Not Shooting State" as NotShooting {
	  state "Idle mode" as Idle
	  state "Configuring mode" as Configuring
	  [*] --> Idle
	  Idle --> Configuring : EvConfig
	  Configuring --> Idle : EvConfig
	}
	
	note right of NotShooting : This is a note on a composite state
	
	@enduml

##显示参数

使用skinparam命令改变字体和颜色。
在如下场景使用：

- 在图示定义中，
- 在包含进来的文件中，
- 在命令行或ANT任务提供的配置文件中。
- 
还可以为状态的构造类型指定特殊的字体和颜色。

	@startuml
	skinparam backgroundColor LightYellow
	skinparam state {
	  StartColor MediumBlue
	  EndColor Red
	  BackgroundColor Peru
	  BackgroundColor<<Warning>> Olive
	  BorderColor Gray
	  FontName Impact
	}
	
	[*] --> NotShooting
	
	state "Not Shooting State" as NotShooting {
	  state "Idle mode" as Idle <<Warning>>
	  state "Configuring mode" as Configuring
	  [*] --> Idle
	  Idle --> Configuring : EvConfig
	  Configuring --> Idle : EvConfig
	}
	
	NotShooting --> [*]
	@enduml