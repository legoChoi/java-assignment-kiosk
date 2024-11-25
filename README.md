# 키오스크
## 요구 사항
1. 개별 음식 항목인 MenuItem 클래스와 MenuItem 클래스를 리스트에 넣어서 관리하는 Menu 클래스

2. 장바구니, 구매(주문), 취소 기능 구현

3. Enum을 사용한 장바구니 -> 주문 시 등급 별 할인 기능

4. 람다, 스트림을 이용한 조회 기능

5. 스트림을 사용한 장바구니 내 메뉴 취소 로직

---
## 구현한 기능
1. 메뉴 장바구니에 추가 기능
2. 메뉴 장바구니에서 삭제 기능
3. 메뉴 장바구니에서 할인 후 주문 리스트에 추가 기능
4. 주문 리스트에 있는 내역 삭제 기능


---
## 클래스 다이어그램
![키오스크 클래스 다이어그램](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbo5gkJ%2FbtsKTqN3Hay%2FpaYqe2MNvoaQmOpmCp4UKk%2Fimg.png)

## 폴더 구조
![키오스크 폴더 구조](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FD47Pr%2FbtsKVyjgifD%2F2uIRTAPVLwLhPuMXCTYfd1%2Fimg.png)
---
출력 예시
1. 메인 화면
```
[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료            | 종료

[ ORDER MENU ]
4. Orders        | 장바구니를 확인 후 주문합니다.
5. Cancel        | 진행중인 주문을 취소합니다.
>> 1
```
2. 메뉴 선택 후 주문
```
[ BURGERS MENU ]
1. ShackBurger    | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack     | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger   | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger      | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
>> 1
선택한 메뉴: ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거

"ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거"
위 메뉴를 장바구니에 추가하시겠습니까?
1. 확인         2. 취소
>> 1
ShackBurger가 장바구니에 추가되었습니다.
```
3. 장바구니 내 메뉴 할인 선택 후 주문 기능 
```
[ ORDER MENU ]
1. ShackBurger    | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거

[ Total ]
W 6.9

1. 주문         2. 삭제         3. 메뉴판
>> 1

할인 정보를 입력해주세요.
1. 국가 유공자        : 10%
2. 군인            : 5%
3. 학생            : 3%
4. 일반            : 0%
5. 고전파           : 99%
>> 2
주문이 완료되었습니다. 금액은 W 6.6 입니다.
```
4. 주문 내역 조회 기능
```
   [ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료            | 종료

[ ORDER MENU ]
4. Orders        | 장바구니를 확인 후 주문합니다.
5. Cancel        | 진행중인 주문을 취소합니다.
>> 5

[ Orders ]
1.
ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
[Total]
W 6.6

제거하려는 주문을 선택해 주세요.
0. 종료
>> 
```