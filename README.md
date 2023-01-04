## TODO List 서비스 설명

완벽한 명세는 아니니, 고민의 여지가 있는 경우 자의적으로 해석하여 구현/구성하시면 됩니다.

### 필수 요구 사항

**회원 관련**

-   유저는 서비스에 가입 할 수 있어야 한다.
-   서비스에 가입 한 유저를 회원 이라고 한다.
-   회원은 서비스에 로그인 및 탈퇴 할 수 있어야 한다.
-   회원은 닉네임을 가진다.


**TODO List 관련**

-   회원은 TODO List를 작성할 수 있어야 한다.
-   회원은 작성한 TODO List를 아래와 같이 조회할 수 있어야 한다.
    -   가장 최근의 TODO 1개
    -   전체 목록
-   회원은 작성한 TODO List의 상태를 아래와 같이 변경할 수 있어야 한다.
    -   할 일
    -   진행중
    -   완료됨



기능 요구 사항

#### 회원
- [x]  유저는 서비스에 가입 할 수 있어야 한다.
- [x]   회원은 서비스에 로그인 및 탈퇴 할 수 있어야 한다.
- [x]   회원은 닉네임을 가진다.

#### todo list
- [x]   회원은 TODO List를 작성할 수 있어야 한다.
- [x]   회원은 작성한 TODO List를 아래와 같이 조회할 수 있어야 한다.
    -   가장 최근의 TODO 1개
    -   전체 목록
- [x]   회원은 작성한 TODO List의 상태를 아래와 같이 변경할 수 있어야 한다.
    -   할 일
    -   진행중
    -   완료됨
- [x] TODO List 서비스를 사용할 수 있는 간단한 View 만들기
    - 상태 변경 제외한 나머지 구현

DB 정보

MySQL
id : root
pw : application.properties 8번 라인에 입력  

CREATE DATABASE `moais` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;  

CREATE TABLE `member` (  
`ID` int NOT NULL AUTO_INCREMENT,  
`LOGIN_ID` varchar(30) NOT NULL,  
`PASSWORD` varchar(45) NOT NULL,  
`NICKNAME` varchar(20) NOT NULL,  
`JOIN_DT` varchar(45) DEFAULT NULL,  
`LAST_LOGIN_DT` varchar(45) DEFAULT NULL,  
`SIGN_OUT_YN` varchar(1) DEFAULT NULL,  
`SIGN_OUT_DT` varchar(45) DEFAULT NULL,  
PRIMARY KEY (`ID`,`LOGIN_ID`),  
UNIQUE KEY `LOGIN_ID_UNIQUE` (`LOGIN_ID`)  
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;  
SELECT * FROM MOAIS.MEMBER;  


CREATE TABLE `to_do_list` (
`ID` int NOT NULL AUTO_INCREMENT,  
`CONTENT` varchar(45) NOT NULL,  
`LAST_MODIFY_DT` varchar(45) DEFAULT NULL,  
`STATUS` varchar(45) DEFAULT NULL,  
`FIRST_REGIST_DT` varchar(45) DEFAULT NULL,  
`LOGIN_ID` varchar(30) NOT NULL,  
PRIMARY KEY (`ID`)  
) ENGINE=InnoDB AUTO_INCREMENT=2466 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;  
