알고리즘 파이썬, 문제 풀이 등

> JS → 파이썬
> 

https://dojang.io/mod/page/view.php?id=2176

https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects

# #1. 기본문법

## 1. 연산자

| JS | 파이썬 | 파이썬 시간복잡도 | 비고 |
| --- | --- | --- | --- |
| && |  |  |  |
| || |  |  |  |
| / → floor | // |  |  |
| undefined |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |

## 2. 문법

| JS | 파이썬 | 파이썬 시간복잡도 | 비고 |
| --- | --- | --- | --- |
| const func=() ⇒ {} | def func(): |  |  |
|  |  |  |  |
|  |  |  |  |

# #2. 빌트인 구조체

## 1. Array - 리스트

| JS | 파이썬 | 파이썬 시간복잡도 | 비고 |
| --- | --- | --- | --- |
| .length | len() | O(1) |  |
| .pop() | .pop() | O(1) |  |
| .push() | .append() | O(1) |  |
| .shift() | pop(0) or remove() | O(n) |  |
| .splice() | X |  |  |
| .slice() | 리스트 슬라이싱 | O(k) |  |
| .forEach() | for (enumerate() 같이) | O(n) |  |
| .map() | map(func, listName) | O(n) |  |
| .filter() | filter() | O(n) |  |
| .reduce() | reduce() | O(n) | import functools |
| .reverse() | reverse() | O(n) |  |
| .sort() | sort() | O(n log n) |  |
| .join() | “”.join() | O(n) |  |
|  | .remove(element) | O(n) | 특정 요소 제거 |
| indexOf() | find() | O(n) |  |
| includes() | in 연산자 | O(n) | O(1) (집합, 딕셔너리) |
| findIndex() | index() with condition |  O(n) |  |

## 2.문자열

| JS | 파이썬 | 파이썬 시간복잡도 | 비고 |
| --- | --- | --- | --- |
| .split(””) | list() | O(1) |  |
| .split(” “) | .split(” “) | O(1) |  |
| .includes() | in | O(n) |  |
| .indexOf() | find() | O(n) |  |
| .match() | re 모듈 | O(n) |  |
| .padEnd() | ljust() | O(n) |  |
| .padStart() | rjust() | O(n) |  |
| .repeat() | * 연산자 | O(n) |  |
| .replace() | replace() |  O(n) |  |
| .fromCharCode() | chr() | O(1) |  |
| .slice() | 문자열 슬라이싱 | O(n) |  |
| .toLowerCase() | lower() | O(n) |  |
| .toUpperCase() | upper() | O(n) |  |
| .trim() | strip() |  O(n) |  |

## 3. Map - dictionary

- js 에서 Map 과 Object 의 비교

https://jake-seo-dev.tistory.com/348

| JS Map | 파이썬 | 파이썬 시간복잡도 | 비고 |
| --- | --- | --- | --- |
| Map: |  |  |  |
| .size | len() | O(1) |  |
| .get() | get() | O(1) |  |
| .has() | in 연산자 | O(1) |  |
| .set() | [key] = value | O(1) |  |
| .clear() | clear() | O(1) |  |
| .delete() | del 연산자 | O(1) |  |
| .entries() | items() | O(n) |  |
| .values() | values() | O(n) |  |
| .keys() | keys() | O(n) |  |
| .forEach() | for 루프 |  O(n) |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |

## 4. Set  - dictionary

| JS | 파이썬 | 파이썬 시간복잡도 | 비고 |
| --- | --- | --- | --- |
| Map: |  |  |  |
| .size |  | O(1) |  |
| .has() |  | O(1) |  |
| .add() |  | O(1) |  |
| .clear() |  | O(1) |  |
| .delete() |  | O(1) |  |
| .entries() |  | O(n) |  |
| .values() |  | O(n) |  |
| .keys() |  | O(n) |  |
| .forEach() |  |  O(n) |  |
| .union() |  |  |  |
| .intersection() |  |  |  |
| .difference() |  |  |  |
|  |  |  |  |

## 5. Math
