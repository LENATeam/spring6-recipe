# 6장

1. WSL 이용해서 구성하기 (powershell 이용)
    1. 설치 os 확인

        원하는 OS을 선택해서 설치 진행 (여기서는 OracleLinux_8_7 으로 진행) 

        1. wsl —list —online 
            
            ```bash
            $ wsl —list —online 
            'wsl.exe --install <Distro>'를 사용하여 설치합니다.
            
            NAME                                   FRIENDLY NAME
            Ubuntu                                 Ubuntu
            Debian                                 Debian GNU/Linux
            kali-linux                             Kali Linux Rolling
            Ubuntu-18.04                           Ubuntu 18.04 LTS
            Ubuntu-20.04                           Ubuntu 20.04 LTS
            Ubuntu-22.04                           Ubuntu 22.04 LTS
            OracleLinux_7_9                        Oracle Linux 7.9
            OracleLinux_8_7                        Oracle Linux 8.7
            OracleLinux_9_1                        Oracle Linux 9.1
            openSUSE-Leap-15.5                     openSUSE Leap 15.5
            SUSE-Linux-Enterprise-Server-15-SP4    SUSE Linux Enterprise Server 15 SP4
            SUSE-Linux-Enterprise-15-SP5           SUSE Linux Enterprise 15 SP5
            openSUSE-Tumbleweed                    openSUSE Tumbleweed
            ```
            
        2. wsl --install OracleLinux_8_7
            
            ```bash
            $ wsl --install OracleLinux_8_7
            Installing, this may take a few minutes...
            Please create a default UNIX user account. The username does not need to match your Windows username.
            For more information visit: https://aka.ms/wslusers
            Enter new UNIX username: [UserId 입력]
            Changing password for user lena.
            New password:
            BAD PASSWORD: The password is shorter than 8 characters
            Retype new password:
            passwd: all authentication tokens updated successfully.
            Installation successful!
            ```
            
    2. docker 설치 
        1. 다운로드 경로 ([WSL2 용 Docker](https://docs.docker.com/desktop/wsl/#download))
            1. [Docker Desktop For windows](https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe?_gl=1*1vdmlsd*_ga*MTQ0NzE3NjA3LjE3MDQ2MTkzMDQ.*_ga_XJWPQMJYHQ*MTcwNDYxOTMwMy4xLjEuMTcwNDYxOTQwMS41NS4wLjA).
        2. 다운 받은 Docker Desktop Installer.exe  설치 
        3. 실행
            
            ![Untitled](3%20virtual%20box%20687770827cdd47f89812c9931a3ef3c5/Untitled%201.png)
            
        4. continue without signing in 으로 진행 후 우측 상단의 setting을 클릭
        5. Use the WSL 2 based engine (Windows Home can only run the WSL 2 backend 선택 
        6. setting > Resources > WSL integration 에 설정확인
            1. default 로 default WSL distro으로 실행 됨 
            2. Enable integration with additional distros: 에서 설치한 버전 Enable
                
                ![Untitled](3%20virtual%20box%20687770827cdd47f89812c9931a3ef3c5/Untitled%202.png)
                
            3. Apply & restart 클릭
        7. k8s 설치 
            1. setting > Kubernetes 에서 Enable Kubernetes을 check 후 Apply & restart
            
            ![Untitled](3%20virtual%20box%20687770827cdd47f89812c9931a3ef3c5/Untitled%203.png)
            
        8. kubectl 은 별도로 설치 필요 
            1. x86 : curl -LO "https://dl.k8s.io/release/**$(**curl -L -s https://dl.k8s.io/release/stable.txt**)**/bin/linux/amd64/kubectl"
                
                ```bash
                $curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
                
                  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                                 Dload  Upload   Total   Spent    Left  Speed
                100   138  100   138    0     0    696      0 --:--:-- --:--:-- --:--:--   696
                100 47.4M  100 47.4M    0     0  26.0M      0  0:00:01  0:00:01 --:--:-- 33.6M
                ```
                
            2. install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl (root 권한)
            3. 버전 확인 
                
                ```bash
                $kubectl version --client
                
                Client Version: v1.29.0
                Kustomize Version: v5.0.4-0.20230601165947-6ce0bf390ce3
                ```
                
            4. powershell 에서는 조회 / wsl 에서는 조회 안됨 
                
                ```powershell
                #powershell 에서 실행 
                > kubectl config get-contexts
                CURRENT   NAME             CLUSTER          AUTHINFO         NAMESPACE
                *         docker-desktop   docker-desktop   docker-desktop
                
                > pwd
                
                Path
                ----
                C:\Users\[User]\.kube
                
                > dir
                
                    디렉터리: C:\Users\[User]\.kube
                
                Mode                 LastWriteTime         Length Name
                ----                 -------------         ------ ----
                d-----      2024-01-07   오후 8:31                cache
                -a----      2024-01-07   오후 8:09           5696 config
                
                # 여기의 config 파일을 복사하여 WSL의 .kube/config에 붙여넣기 
                ```
                
                ```bash
                #WSL에서 kubectl 실행시 window에 설치된 docker 및 kubectl이 정상 접속이 안됨 
                $kubectl config get-contexts
                CURRENT   NAME             CLUSTER          AUTHINFO         NAMESPACE
                
                #root 권한에서 
                $cd 
                $pwd
                /root
                $mkdir .kube
                $vi .kube/config
                #으로 window의  .kube/config 내용 복사 
                
                #복사 이후 아래와 같이 정상 조회 
                
                ```
                
                ```
                #.kube/config  내용 예시 
                
                apiVersion: v1
                clusters:
                - cluster:
                    certificate-authority-data: LS0tLS1CRUdJTiBDRVJUSUZJ 
                ~~
                server: https://kubernetes.docker.internal:6443
                  name: docker-desktop
                contexts:
                - context:
                    cluster: docker-desktop
                    user: docker-desktop
                  name: docker-desktop
                current-context: docker-desktop
                kind: Config
                preferences: {}
                users:
                - name: docker-desktop
                  user:
                    client-certificate-data:
                ~~~
                
                ```
                
            5. kubectl 자동 완성
                
                ```bash
                $yum install bash-completion #rhel 계열 시 
                $kubectl completion bash | sudo tee /etc/bash_completion.d/kubectl > /dev/null
                $exec bash
                ```
                
            
        9. WSL 접속하여 docker info으로 확인 
            
            ```bash
            $docker info
            # docker info
            Client: Docker Engine - Community
             Version:    24.0.7
             Context:    default
             Debug Mode: false
             Plugins:
              buildx: Docker Buildx (Docker Inc.)
                Version:  v0.12.0-desktop.2
                Path:     /usr/local/lib/docker/cli-plugins/docker-buildx
              compose: Docker Compose (Docker Inc.)
                Version:  v2.23.3-desktop.2
                Path:     /usr/local/lib/docker/cli-plugins/docker-compose
              dev: Docker Dev Environments (Docker Inc.)
                Version:  v0.1.0
                Path:     /usr/local/lib/docker/cli-plugins/docker-dev
            ```
            
        
    3. postgres DB을 설치 및 기동 
        1. bin\postgres.sh 와 bin\psql.sh 으로 실행 (WSL 에 접속 후 실행- root 접)
        2. bin\postgres.sh - postgres 을 실행(image 없을 경우 Image을 다운도 진행)
            
            ```bash
            # bin\postgres.sh
            #!/bin/bash
            docker run --name s6r-postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=vehicle -p 5432:5432 -d postgres
            Unable to find image 'postgres:latest' locally
            latest: Pulling from library/postgres
            af107e978371: Pull complete
            4dab593eebe3: Pull complete
            4998fa695fba: Pull complete
            68722367c502: Pull complete
            ......
            ca09208e18c7: Pull complete
            Digest: sha256:b09f2562ab14fcae750cfc5ae457cd97e90c37679f520bc4a84180913de90261
            Status: Downloaded newer image for postgres:latest
            5f1565cc149ceef6d9d17ef7ab567f943638f109a46b898282d200fbafe3566e
            
            $ docker ps
            CONTAINER ID   IMAGE      COMMAND                  CREATED          STATUS          PORTS                    NAMES
            5f1565cc149c   postgres   "docker-entrypoint.s…"   26 seconds ago   Up 24 seconds   0.0.0.0:5432->5432/tcp   s6r-postgres
            
            # Up 24 seconds ago 기동 중 24s 경과
            ```
            
        3. 실행
            1. Docker Desktop에서 stop 또는 기동  (Action > Stop 또는 Start )
                
                ![Untitled](3%20virtual%20box%20687770827cdd47f89812c9931a3ef3c5/Untitled%204.png)
                
        4. Docker Desktop 에서 확인 
            
            ![Untitled](3%20virtual%20box%20687770827cdd47f89812c9931a3ef3c5/Untitled%205.png)
            
        5. 접속
            1. bin\psql.sh 사용 
                
                ```bash
                # bin\psql.sh
                #!/bin/bash
                
                docker run -it --link ${1:-s6r-postgres}:postgres --rm postgres sh -c 'exec psql -h "$POSTGRES_PORT_5432_TCP_ADDR" -p "$POSTGRES_PORT_5432_TCP_PORT" -U postgres'
                
                Password for user postgres:  #bin\postgres.sh에 설정된 POSTGRES_PASSWORD=password을 입력 : password
                psql (16.1 (Debian 16.1-1.pgdg120+1))
                Type "help" for help.
                
                postgres=#
                #버전확인 
                postgres=# select version();
                                                                       version
                ---------------------------------------------------------------------------------------------------------------------
                 PostgreSQL 16.1 (Debian 16.1-1.pgdg120+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 12.2.0-14) 12.2.0, 64-bit
                (1 row)
                ```
                
                ![Untitled](3%20virtual%20box%20687770827cdd47f89812c9931a3ef3c5/Untitled%206.png)
                
                아래 생성된 container을 통해 postgresql을 접속 함 
                
            2. Database 생성 및 조회 
                
                ```bash
                postgres=# \l
                                                                      List of databases
                   Name    |  Owner   | Encoding | Locale Provider |  Collate   |   Ctype    | ICU Locale | ICU Rules |   Access privileges
                -----------+----------+----------+-----------------+------------+------------+------------+-----------+-----------------------
                 postgres  | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           |
                 template0 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
                           |          |          |                 |            |            |            |           | postgres=CTc/postgres
                 template1 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
                           |          |          |                 |            |            |            |           | postgres=CTc/postgres
                 vehicle   | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           |
                (4 rows)
                
                #기본 image에 Database vehicle이 생성되어 있음
                #DROP DATABASE vehicle; 으로 삭제 후 생성
                #CREATE DATABASE "vehicle"; 으로 생성 "" 으로 생성 
                
                ```
                
                ```bash
                postgres=# SELECT * FROM pg_catalog.pg_tables;
                #목록 확인 후 종료는 q
                
                #2곳 모두 생성이 필요함 database "vehicle"과 가장 기본생성되어 있는 postgres 둘다 실행 
                postgres=# CREATE TABLE VEHICLE (
                 VEHICLE_NO VARCHAR(10) NOT NULL,
                 COLOR VARCHAR(10),
                 WHEEL INT,
                 SEAT INT,
                 PRIMARY KEY (VEHICLE_NO)
                );
                CREATE TABLE
                
                #vehicle database으로 이동하여 table 생성
                postgres=# \c vehicle
                You are now connected to database "vehicle" as user "postgres".
                
                vehicle=# CREATE TABLE VEHICLE (
                 VEHICLE_NO VARCHAR(10) NOT NULL,
                 COLOR VARCHAR(10),
                 WHEEL INT,
                 SEAT INT,
                 PRIMARY KEY (VEHICLE_NO)
                );
                CREATE TABLE
                
                vehicle=# SELECT * FROM pg_catalog.pg_tables;
                
                schemaname     |        tablename         | tableowner | tablespace | hasindexes | hasrules | hastriggers | rowsecurity
                --------------------+--------------------------+------------+------------+------------+----------+-------------+-------------
                 public             | vehicle                  | postgres   |            | t          | f        | f           | f
                 pg_catalog         | pg_statistic             | postgres   |            | t          | f        | f           | f
                 pg_catalog         | pg_type                  | postgres   |            | t          | f        | f           | f
                
                =# SELECT * From vehicle;
                 vehicle_no | color | wheel | seat
                ------------+-------+-------+------
                (0 rows)
                
                #참고
                postgres=#  SELECT * From vehicle;
                ERROR:  relation "vehicle" does not exist
                #결과없음
                ```
                
            3. table 생성 및 조회 
            4. table 전체 삭제 
                
                ```bash
                truncate table vehicle ;
                truncate table vehicle restart identity; #sequence도 초기화
                ```

1. virtual box 설치 (Update예정)

[https://www.virtualbox.org/](https://www.virtualbox.org/)

![Untitled](3%20virtual%20box%20687770827cdd47f89812c9931a3ef3c5/Untitled.png)

version : VirtualBox-7.0.12