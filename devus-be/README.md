## Project Structure
```
|- configurations
|- devus-api
|- devus-config
```

## configurations
- devus 서비스 설정파일 관리

##### 파일 명명 규칙
```
{application-name}-{profile}.yaml

e.g.
devus-api-dev.yaml => {devus-api} 서비스 {dev} 환경 설정파일
```
- application-name : 서비스명, `spring.appliccation.name`으로 지정
- profile : 구동환경, `spring.profiles.active` 혹은 프로그램 인자로 지정

## devus-api
- devus 서비스 API 제공 앱
- 프로젝트 설정파일은 

## devus-config
- devus 서비스 설정파일 제공 앱
- configurations 디렉토리 내 관리되는 설정파일을 서빙하는 역할

##### 참조방식
```
http://IP:PORT/{application-name}/{profile}

e.g.
http://localhost:8080/devus-api/dev => {devus-api} 서비스의 {dev} 환경 설정파일 내용을 서빙
```
