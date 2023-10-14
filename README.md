# 프리온보딩 백엔드 인턴십 선발과제

# ⚒️ 기술 환경 및 tools
- Back-End: Spring Boot 2.7.16, Java 11, Gradle
- ETC: Git, Github, Postman, Mysql

</br>
</br>

# 🔖 실행 방법

- 레포지토리를 clone 받아서 진행합니다.
- Spring Boot 프로젝트의 루트 디렉토리로 이동합니다.
- ./gradlew build 명령어를 실행합니다.
- build/libs 경로에서 java -jar wanted-0.0.1-SNAPSHOT.jar 명령어를 실행합니다.

</br>
</br>

# 📕 과제 수행 내역
### [개발 사항]
✔️ REST API 기능
- 채용공고를 등록합니다.
  - url: ```POST``` ```http://localhost:8080/jobposting```
  - 입력:
  ```
  {
    "company_id": 1,
    "position": "백엔드 주니어 개발자",
    "reward": 1000000,
    "skill": "Python",
    "description": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은.."
  }
  ```
  - 출력:
  ```
  {
    "company_id": 1,
    "company_name": "원티드랩",
    "country": "힌국",
    "location": "서울",
    "position": null,
    "reward": 1000000,
    "description": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "skill": "Python"
  }
  ```
  </br>
- 채용공고를 수정합니다.
  - url: ```PATCH``` ```http://localhost:8080/jobposting/1```
  - 입력: 
  ```
  {
    "position": "백엔드 주니어 개발자",
    "reward": 1500000,
    "skill": "Django",
    "description": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은.."
  }
  ```
  - 출력:
  ```
  {
    "posting_id": 1,
    "company_id": 1,
    "company_name": "원티드랩",
    "country": "한국",
    "location": "서울",
    "position": "백엔드 주니어 개발자",
    "reward": 1500000,
    "description": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "skill": "Django"
  }
  ```
  </br>
- 채용공고를 삭제합니다.
  - url: ```DELETE``` ```http://localhost:8080/jobposting/1```
  </br>
  
- 채용공고 목록을 가져옵니다.
  - 사용자는 채용공고 목록을 아래와 같이 확인할 수 있습니다.
    - url: ```GET``` ```http://localhost:8080/jobposting```
    - 출력:
    ```
    [
    {
        "posting_id": 1,
        "company_name": "원티드랩",
        "country": "한국",
        "location": "서울",
        "position": "백엔드 주니어 개발자",
        "reward": 1000000,
        "skill": "Python"
    },
    {
        "posting_id": 2,
        "company_name": "원티드코리아",
        "country": "한국",
        "location": "부산",
        "position": "Django 백엔드 개발자",
        "reward": 1000000,
        "skill": "Django"
    }
    ]
    ```
    </br>
  -  채용공고 검색 기능 구현(선택사항 및 가산점요소).
    - url: ```GET``` ```http://localhost:8080/jobposting/url?search=원티드```
    - 출력:
    ```
    [
    {
        "posting_id": 1,
        "company_name": "원티드코리아",
        "country": "한국",
        "location": "부산",
        "position": "백엔드 주니어 개발자",
        "reward": 1000000,
        "skill": "Python"
    },
    {
        "posting_id": 2,
        "company_name": "원티드랩",
        "country": "한국",
        "location": "서울",
        "position": "백엔드 주니어 개발자",
        "reward": 1000000,
        "skill": "Python"
    }
    ]
    ```
    </br>
- 채용 상세 페이지를 가져옵니다.
  - url: ```GET``` ```http://localhost:8080/jobposting/1```
  - 출력:
  ```
  {
    "posting_id": 1,
    "company_name": "원티드랩",
    "country": "한국",
    "location": "서울",
    "position": "백엔드 주니어 개발자",
    "reward": 1000000,
    "skill": "Python",
    "description": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    "otherJobPostingList": [
        1,
        2,
        3,
        4
    ]
  }
  ```
  </br>
- 사용자는 채용공고에 지원합니다(선택사항 및 가산점요소).
  - url: ```POST``` ```http://localhost:8080/jobposting/1/1```
  - 출력:
  ```
  {
    "posting_id": 1,
    "applicant_id": 1
  }
  ```  
    
</br>

### PostMan API 명세서

Postman을 활용하여 API 작동 테스트를 진행했습니다.

자세한 API 명세는 아래에서 확인 가능합니다.

[API 명세서](https://documenter.getpostman.com/view/25956865/2s9YR57aow)

</br>
</br>

# 📂DB ERD
<img width="492" alt="ERD" src="https://github.com/ichubtou/wanted-pre-onboarding-backend/assets/106014960/64281315-cc74-497a-875d-fff543d8ff8a">

</br>
</br>

# 🌱Git Convention
```
feat : 새로운 기능 추가
fix : 버그 수정
docs : 문서 수정
style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
refactor : 코드 리펙토링
test : 테스트 코드, 리펙토링 테스트 코드 추가
chore : 빌드 업무 수정, 패키지 매니저 수정
```
