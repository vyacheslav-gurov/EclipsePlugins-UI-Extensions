# Eclipse Plugins (UI-Extensions)

В этом репозитории я собираю исходники для Plug-in Project Eclipse, демонстрирующие создание/настройку различных UI-расширений для Eclipse. Материал рассчитан главным образом для начинающих. 

1. [View](https://github.com/firstevilbit/EclipsePlugins-UI-Extensions/tree/master/ProjectTabs/src/org/evilbit/simpleview)

## 1. [View](https://github.com/firstevilbit/EclipsePlugins-UI-Extensions/tree/master/ProjectTabs/src/org/evilbit/simpleview)
Это пример самой наипростейшей реализации расширение org.eclipse.ui.views. Для того чтобы открыть View нажмите *Window > Show View > Other... > Category Simple View > Simple View*

В plugins.xml есть \<extension point="org.eclipse.ui.views"\>, которая содержит настройки для view. В поле class указана реализация этой view. Она находится в пакете org.evilbit.simpleview, это элементарный класс **SimpleViewClass** расширяющий ViewPart.

Результат:

![Picture](Images/simpleview1.jpg) ![Picture](Images/simpleview2.jpg)