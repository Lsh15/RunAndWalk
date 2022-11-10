# RunningApp
## 구글 맵을 이용한 운동 기록 앱

Google Maps SDK for Android 를 이용하여 운동(걷기, 뛰기)기록 App을 제작하였습니다.

![image](https://user-images.githubusercontent.com/50148363/196395740-845faf92-5f63-4b5a-992d-5fec819ed1ff.png)

코드에서 API 사용하려면 별도의 개인 API를 사용해야 합니다.

### App 실행화면
#### 초기 실행화면
<img src = "https://user-images.githubusercontent.com/50148363/196392530-be2a2d42-1398-4dc0-be2a-defc72cc67dc.png" width="300" height="500"/> 
사용자의 정보와 운동 유형(걷기, 뛰기)을 입력받습니다.

#### 산책 기록 화면
<img src = "https://user-images.githubusercontent.com/50148363/196392943-a8a29527-c8f3-4b6a-aec6-aa1c93595f60.png" width="300" height="500"/> 
운동 기록을 확인할 수 있으며 정렬이 가능합니다.

#### 통계 화면
<img src = "https://user-images.githubusercontent.com/50148363/197082533-919cca4d-9f08-4d1e-b5c2-e31e693904e5.png" width="300" height="500"/> 
통계를 확인할 수 있습니다.

#### 설정 화면
<img src = "https://user-images.githubusercontent.com/50148363/196393213-9bf68c7f-01c8-4814-8bee-0335acc5ebc5.png" width="300" height="500"/> 
초기 설정을 수정할 수 있습니다.

#### 추적 화면
<img src = "https://user-images.githubusercontent.com/50148363/196393699-2136fab6-1b82-4ce2-9448-91ba3173a0b2.png" width="300" height="500"/>
운동 경로, 시간이 실시간으로 표시됩니다.

#### 서비스 화면
<img src = "https://user-images.githubusercontent.com/50148363/197082545-421fe175-7268-473f-bba4-8c1b2d1bf596.png" width="300" height="300"/>
앱이 백그라운드에서 계속 작동합니다.

### 사용한 라이브러리 
Name | Description
---|---|
Navigation | 프래그먼트 전환 라이브러리 
Glide | 이미지 로딩 라이브러리 
ViewModel | 수명주기 고려 데이터를 저장, 관리 라이브러리 
Coroutine | 비동기 처리 라이브러리  
Coroutine Flow | 비동기 데이터 스트림 
Dagger Hilt | 의존성 주입 라이브러리 
GoogleMap | 구글 지도 라이브러리  
Mp Android Chart | 안드로이드 차트 통계 라이브러리  
Room | 안드로이드 DB 라이브러리  

기존의 코드를 참고하여 제작되었습니다 

https://github.com/philipplackner/RunningAppYT













