<br />
<p align="center">
  <h3 align="center">JAVA Spring boot grpc</h3>
</p>



<!-- TABLE OF CONTENTS -->
## Outline

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)



<!-- ABOUT THE PROJECT -->
## About The Project

目標為Spring boot grpc 原型專案，提供未來開發參考。

* 啟動前需先安裝JAVA

### Built With
* [JAVA](https://www.java.com/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [gRPC](https://https://grpc.io/)
* [LogNet/grpc-spring-boot-starter](https://github.com/LogNet/grpc-spring-boot-starter)


<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

1. 安裝JAVA

### Installation

1. Clone the repo
```sh
git clone https://github.com/TCFeng/spring-boot-grpc.git
```
2. Install gradle packages
```sh
cd code\backend\web_server
gradlew build
```

<!-- USAGE-->
## Usage
1. 啟動後台
```sh
gradlew bootRun
```
2. API 測試方法
```sh
curl -X GET \
  'http://localhost:8080/grpc/server/getStatusById?serverId=S0001' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 00ef3dc0-e1dc-4f1c-b7e4-80da510fc67f'
```

<!-- CONTRIBUTING -->
## Contributing

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. 


<!-- CONTACT -->
## Contact

TCFeng - tcfeng601@gmail.com

Project Link: [https://github.com/TCFeng/spring-boot-grpc](https://github.com/TCFeng/spring-boot-grpc)
