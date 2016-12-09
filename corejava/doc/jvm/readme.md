清单1-1

    #使用预编译头文件，不加这个编译会更慢一些
    export USE_PRECOMPILED_HEADER=true
    
    #要编译的内容
    export BUILD_LANGTOOLS=true 
    #export BUILD_JAXP=false
    #export BUILD_JAXWS=false 
    #export BUILD_CORBA=false
    export BUILD_HOTSPOT=true 
    export BUILD_JDK=true
    
    #要编译的版本
    #export SKIP_DEBUG_BUILD=false
    #export SKIP_FASTDEBUG_BUILD=true
    #export DEBUG_NAME=debug
    
    #把它设置为false可以避开javaws和浏览器Java插件之类的部分的build。 
    BUILD_DEPLOY=false
    
    #把它设置为false就不会build出安装包。因为安装包里有些奇怪的依赖，但即便不build出它也已经能得到完整的JDK映像，所以还是别build它好了。
    BUILD_INSTALL=false
    
    #编译结果所存放的路径
    export ALT_OUTPUTDIR=/Users/IcyFenix/Develop/JVM/jdkBuild/openjdk_7u4/build
    
    #这两个环境变量必须去掉，不然会有很诡异的事情发生（我没有具体查过这些“”诡异的事情”，Makefile脚本检查到有这2个变量就会提示警告“）
    unset JAVA_HOME
    unset CLASSPATH
    
    make 2>&1 | tee $ALT_OUTPUTDIR/build.log


清单2-3.txt HeapOOM
清单2-4.txt JavaVMStackSOF
清单2-5.txt JavaVMStackOOM
清单2-6.txt RuntimeConstantPoolOOM
清单2-7.txt RuntimeConstantPoolOOM2
清单2-8.txt JavaMethodAreaOOM
清单2-9.txt DirectMemoryOOM

清单3-1.txt ReferenceCountingGC
清单3-2.txt FinalizeEscapeGC
清单3-5.txt
清单3-6.txt
清单3-7.txt
清单3-8.txt
清单3-9.txt

清单4-5.txt
清单4-6.txt
清单4-8.txt
清单4-9.txt
清单4-10.txt
清单4-11.txt
清单4-12.txt

清单6-1.txt

清单7-1.txt
清单7-2.txt
清单7-3.txt
清单7-4.txt
清单7-5.txt
清单7-6.txt
清单7-7.txt
清单7-8.txt

清单8-1.txt
清单8-2.txt
清单8-3.txt
清单8-4.txt
清单8-5.txt
清单8-6.txt
清单8-7.txt
清单8-8.txt
清单8-10.txt
清单8-11.txt
清单8-12.txt
清单8-14.txt
清单8-15.txt

清单9-1.txt
清单9-2.txt
清单9-3.txt
清单9-4.txt
清单9-5.txt
清单9-6.txt
清单9-7.txt
清单9-8.txt

清单10-1.txt
清单10-2.txt
清单10-3.txt
清单10-4.txt
清单10-5.txt
清单10-6.txt
清单10-7.txt
清单10-8.txt
清单10-9.txt
清单10-10.txt
清单10-11.txt
清单10-12.txt
清单10-13.txt

清单11-2.txt

清单12-1.txt
清单12-5.txt

清单13-2.txt
清单13-3.txt
清单13-4.txt
清单13-5.txt