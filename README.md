# Objects

책을 구매한지 1년 반이 지났으나 완독하지 못했다. 마의 영화관 구간을 넘지 못하고 계속 회귀했기 때문이다.

따라서 직접 코드를 작성해서 비교하며 진도를 나가는 것을 시도해본다.

이왕 하는거 코틀린으로 컨버팅하고 예제와 비교하며 진행해본다.

> 현재는 각 구조의 변화를 보기 쉬운 방법을 고민 중인데, 일단은 리팩토링 횟수만큼 패키지를 만들어 관리해보려한다.
> 
> 설명할때 예시 자료로도 쓸 수 있을 것 같아서인데, 많이 비효율적인 것 처럼 느껴지면 브랜치를 나누거나 커밋으로 분리하는 것을 시도해보려 한다.

## 현재 생각 중인 프로세스?

1. 각 챕터별 패키지(혹은 모듈)을 생성하여 구분한다.
2. 해당 단위별로 README를 만들어 나오는 요구사항 혹은 이론적 내용을 정리한다.
    1. 정리하며 객체지향의 사실과 오해에서 익혔던 내용들을 풀어내며 정리해본다.
3. 코드 발전 사항을 볼 수 있도록 개선 전, 후를 패키지로 나누어 보관한다.
4. 중요한건(핵심) 일단 여기에 적어둔다.

> 표기는 주석

>> 표기는 본문에 나오는 설명 이외의 주석 + 개인적인 생각이다.

## 객체지향에 대한 생각 정리

- 객체지향 프로그래밍이란?
   - 객체들이 각자의 책임을 갖고 상호작용 하는 것
- 왜 하나?
   - 현실 세계를 이해하기 쉽게 모델링하는 방법론
   - 시스템을 유연하게 만드는데 도움을 준다(낮은 결합도와 높은 응집도)
- 우리가 java 프로그래밍을 처음 배울때 듣는 캡슐화, 상속, 다형성, 추상화가 이를 도와준다.
   - 상속을 재사용 관점에서만 보면 안 된다. 이런 관점에서 상속을 하면 높은 확률로 캡슐화가 꺠진다(자식이 부모의 상태를 변경할 수 있게 되니까)
   - 객체지향 관점에서 상속은 다형성을 구현하기 위해 자식 클래스들의 인터페이스를 통일시키기 위한 수단 중 하나이다(서브 타이핑).
- SOLID 에도 중요한 개념이 많이 들어있지만 이건 나중에
