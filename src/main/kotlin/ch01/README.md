# 01. 객체, 설계

> 잘치지향에서 객체지향으로 가는 가장 쉬운 접근 : 데이터와 프로세스를 한 군데로 모아보기

## 기억나는 것들

### 소프트웨어 모듈이 가져야 하는 세 가지 기능

1. 제대로 동작해야 한다(모듈의 존재 이유).
2. 간단한 작업만으로도 변경이 가능해야 한다. 변경하기 어렵다면 제대로 동작하더라도 개선해야 한다.
3. 개발자가 쉽게 읽고 이해할 수 있어야 한다. 그렇지 않다면 개선해야 한다.

### 프로세스와 데이터가 별도의 모듈에 위치하는 것을 절차적(Procedural) 프로그래밍이라고 한다.

- 절차적 프로그래밍 세상은 우리의 예상과 다르게 움직이기 때문에 코드를 읽는 사람과 원활하게 의사소통하지 못한다.
- 절차적 프로그래밍은 데이터의 변경으로 인한 영향을 고립시키기 힘들다.

### 좋은 설계란?

1. 오늘 완성해야 하는 기능을 구현하는 코드를 짜야 한다.
2. 내일 쉽게 변경할 수 있는 코드를 짜야 한다(변경을 수용할 수 있어야 한다).

### 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 하는 것을 객체지향 프로그래밍이라 한다.

- 그 과정에서 의존성이 추가될 수도 있다. 대신 하나의 변경으로 인한 여파가 여러 클래스로 전파되는 것을 억제할 수 있게 됐다.
- 캡슐화를 이용해 의존성을 적절히 관리함으로써 객체 사이의 결합도를 낮춰야 한다. 객체지향 프로그래밍은 의존성을 효율적으로 통제할 수 있는 다양한 방법을 제공한다.
- 적절한 객체에 적절한 책임을 할당하는 것이 중요하다.

> 사물에게도 책임을 부여할 수 있다. 이것이 객체지향과 현실세계의 차이점이다. 이러한 부분은 직관적이지 않을 수 있다. 객체지향 세계에서는 객체를 능동적이고 자율적인 존재로 만들기 위해 의인화(
> anthropomorphism)를 사용한다.

### 절차지향에서 객체지향에 가깝도록 만드는 가장 쉬운 접근 : 데이터와 프로세스를 하나의 클래스 안에 담아두기

- 데이터와 프로세스를 하나의 클래스 안에 담아두면 자연스럽게 캡슐화가 된다.
    - 캡슐화란? 외부에 내부를 노출하지 않는 것(가장 쉬운 방법? getter 없애기)
      > private 으로 만든다고 캡슐화가 아니다. getter가 있으면 결국 내부에서 제어해야 될 상태들이 외부에 노출된다.
      >
      > 디미터 법칙이라는 것도 있다. + tell, don't ask(TDA 원칙) https://martinfowler.com/bliki/TellDontAsk.html
- 캡슐화가 되면 자연스럽게 구현이 아닌 인터페이스에 의존하게 된다(추상화).
    - 필드에 직접 접근하지 않고 메소드를 통해 접근하니까. 요구사항이 바뀌면 다른 구현을 사용하면 된다(다형성)
- 인터페이스에 의존하게 되면 의존성도 최소화 될 가능성이 높다. 의존성이 적어지면 결합도가 낮아진다.
- 이렇게 되면 자연스럽게 자신과 연관성이 없는 작업은 다른 객체에게 맡기게 된다. 이러면 응집도가 높아진다.
    - 객체가 수동적인 존재가 아니라 자율적인 존재가 된다. 자기가 맡은 일(책임)은 스스로 처리한다.(정확히는 외부에서 양식에 맞춰서 메세지를 보내면 일을 어떻게 처리할지(메소드의 구현)를 스스로 결정하는
      것이다.)
- 하지만 가장 중요한 것은 책임을 적절하게 나누는 것
- 그리고 의존성을 잘 관리 하는 것
- 객체지향은 은총알이 아니다
    - 객체지향을 깨는 설계가 더 적절하다면 그것을 선택해야 한다.
    - 객체지향을 한다고 더러운 부분들이 마법처럼 없어지지 않는다. 어디에 잘 모아둘지를 결정하는 것(기적의 수납법이 필요하다)
