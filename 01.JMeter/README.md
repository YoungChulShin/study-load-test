# JMeter
JMeter를 설치하고, 테스트하는 방법을 정리합니다. 
## 기본 설치 및 실행
### 설치
홈페이지를 통해서 설치
- https://jmeter.apache.org/download_jmeter.cgi

homebrew를 통한 설치
- https://formulae.brew.sh/formula/jmeter#default

플러그인 설치
- jmeter로 테스트를 하면 결과를 볼 때 조금 더 다양한 데이터를 필요할 경우가 있다. 이때 플러그인을 추가함으로써 추가적인 기능을 반영할 수 있다. 
- 플러그인 사이트: https://jmeter-plugins.org/
   - Install 메뉴에서 `plugins-manager`를 설치한다. 

### 실행
설치 경로에서 `bin\ApacheJMeter.jar` 파일을 실행한다. 

### 테스트 계획 생성
테스트 메뉴는 아래 계층 구조를 가진다. 
1. Test Plan
   - test 관련 최 상위 개념. 
   - 하위에 Thread Group 이나 Lisntener를 가질 수 있다. 
2. Thread Group
   - 하위에 test를 가지는 상위 그룹
   - 사용자 수, 실행 횟수 등의 부하테스트에서 중요한 입력 값을 설정할 수 있다.
3. Actual Test(ex: Http request)
   - 실제로 호출해야하는 대상 정보를 기록한다.

리스너 등록
- 테스트 생성 이후에 결과를 보기 위해서 필요한 리스너를 등록할 수 있다. 
- 예: Summary Report, View Results Tree, Hits per Seconds 등
   - 플러그인 매니저로 추가된 리스너는 앞에 'jp@gc'가 붙는다. 

### 테스트 실행 - GUI
홈페이지에서는 CLI 모드에서 해야한다고 하는데, GUI 모드에서도 실행은 가능하다. 

메뉴에서 '초록색 화살표'를 클릭하면 테스트를 실행한다. 
### 테스트 실행 - CLI
`bin/jmeter` 파일을 실행해서 테스트를 시작할 수 있다. 

옵션
- `-n`: non gui
- `-t`: test file. *.jmx file
- `-l`: log file
- `-e`: generate report dashboard after load test
- `-o`: report output folder

샘플 
```
./jmeter -n -t /Users/youngchul.shin/Programs/02.private/study_jmeter/test-plan.jmx -l /Users/youngchul.shin/Programs/02.private/study_jmeter/testlog.jtl -e -o /Users/youngchul.shin/Programs/02.private/study_jmeter/result
```

### 결과 확인
GUI 모드
- 테스트 계획에 추가한 리스너를 클릭하면 결과를 확인할 수 있다. 

CLI 모드
- 옵션으로 report 생성을 지정하면, 지정한 폴더에 결과 내용이 저장된다. 
- 이 파일 중에는 `index.html` 파일을 클릭하면 결과 정보를 확인할 수 있다.

## 테스트에서 활용할 정보
### 입력 값을 랜덤으로 전달하기
