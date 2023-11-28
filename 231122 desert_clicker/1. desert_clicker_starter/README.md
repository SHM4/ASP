Dessert Clicker app
=====================

Code for Android Basics with Compose Codelab.

Introduction
------------

Dessert Clicker is a game about making desserts.

Press the button, make a dessert, earn the big bucks.

You use this app in the course to explore the Android lifecycle and log messages to
the Android console (Logcat).

Pre-requisites
--------------

You need to know:
- How to open, build, and run apps with Android Studio.
- What an activity is, and how to create one in your app.
- What the activity's onCreate() method does, and the kind of operations
  that are performed in that method.


Getting Started
---------------

1. Download and run the app.

# Activity Life Cycle
- 활동 수명 주기 : 활동이 처음 초기화될 때부터 소멸(운영체제(OS)에서 메모리를 회수)될 때까지 활동이 거쳐가는 여러 상태로 구성된다.
- main() : 일반적인 Java 프로그램 진입점 <-> onCreate() : Android에서 Activity의 진입점. 사용자가 앱을 시작하여 사용하고 이동하면 활동이 상태를 바꾼다.
- 활동 수명 주기
  - Initialized -> (onCreate) -> Created -> (onStart/onRestart) -> Started -> (onResume) -> Resumed -> (onPause) -> Started -> (onStop) -> Created -> (onDestroy) -> Destroyed
  - 포커스되는 활동 : Resumed
  - 보여지는 활동 : Started, Resumed

## Activity 클래스
- 여러 서브 클래스를 가지고 있다. (ex: ComponentActivity)
- 일련의 활동 수명 주기 콜백 메서드를 구현한다.
- 활동 수명 주기 상태가 변경될 때 일부 동작을 변경하거나 코드를 실행하는 경우 사용한다.
- Android에서는 활동 상태가 변할 때 이러한 콜백을 호출하고 개발자는 이러한 메서드를 자체 활동에서 재정의하여 수명 주기 상태 변경에 응답해 작업을 실행할 수 있다.
- 콜백 메서드 : onResume(), onPause(), onStart(), onRestart(), onStop(), onCreate(), onDestroy()
  - onRestart() : onStop()이 호출되고 이후에 활동이 다시 시작되는 경우에만 호출되는 메서드. Create와 Started 간 상태가 전환될 때마다 호출되는 것이 아니다.

# onStart()
- onStart()가 실행되면 활동이 화면에 표시된다.
- onCreate() 직후에 호출된다.
- onCreate()는 활동을 초기화하는 데 한 번만 호출되지만, onStart()는 시스템에서 활동의 수명 주기 동안 여러 번 호출할 수 있다.
- onStop()과 페어링된다.
- 사용자가 앱을 시작한 후 기기 홈 화면으로 돌아오면 활동이 중지되고 더 이상 화면에 표시되지 않는다.

# 활동 종료
- 기기에서 '뒤로' 버튼을 탭하면 onPause(), onStop()이 순서대로 호출된다.
- 기기에서 '뒤로' 버튼을 탭하면 활동(및 앱)이 화면에서 삭제되고 활동 스택의 뒤로 이동한다.
- 그 외의 활동 동료 방법 : 코드에서 finish() 메서드를 수동으로 호출. 사용자가 앱을 강제 종료. 앱이 장시간 화면에 표시되지 않으면 OS가 자체적으로 활동을 종료. 등등

# configuration change
- 기기 상태가 매우 급격하게 변경되어 시스템이 변경사항을 확인하는 가장 쉬운 방법이 활동을 완전히 종료하고 다시 빌드하는 것일 때 발생한다.
- ex) 사용자가 기기 언어를 변경, 기기에 새로운 도크를 연결, 기기 방향의 변경
