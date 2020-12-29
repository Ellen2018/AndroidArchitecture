# 说明

>这是一个Android[MVC & MVP & MVVM & 组件化]架构演示如何搭建的项目，仅供参考,Java & Kotlin都有案例，Kotlin搭建的架构放在了app module中了，Java部分放在了java module中了，此外笔者加入单元测试案例到项目中


# MVC  

> 具体笔者不想多做解释，看代码吧

# MVP

> 无论是Kotlin还是Java部分，均采用MVP+Dagger2+Retrofit+RxJava进行构建，而且利用Jetpack的LifeCycle组件让MVP具备生命周期感知功能，防止不必要的内存消耗和泄漏等

> 2020-12-28 加入Kotlin+MVP+Dagger2+Retrofit+协程进行构建

# MVVM

> 有传统MVVM架构，以及新的结合Jet-pack的ViewModel & LiveData搭建的MVVM架构

# 组件化
