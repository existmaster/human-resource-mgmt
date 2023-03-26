
#### Object: employee
#### Type: Deployment

### Cluster에 employee Deployment를 생성하려면 아래의 명령어를 실행하세요.

```
$ kubectl create -f https://minio.msaez.io/labs-msaez.io/yamlStorage/human-resource-mgmt-ex/existmaster%40naver.com/Deployment/employee.yaml?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minio%2F20230326%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230326T055704Z&X-Amz-Expires=60&X-Amz-SignedHeaders=host&X-Amz-Signature=5779afa1073221803c72e631c48b5173a07769b5eebbcc4494930b175ccb8e94
```
- Yaml 파일에 명시된 스펙으로 employee Deployment를 생성합니다.

```
$ kubectl apply -f https://minio.msaez.io/labs-msaez.io/yamlStorage/human-resource-mgmt-ex/existmaster%40naver.com/Deployment/employee.yaml?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minio%2F20230326%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230326T055704Z&X-Amz-Expires=60&X-Amz-SignedHeaders=host&X-Amz-Signature=5779afa1073221803c72e631c48b5173a07769b5eebbcc4494930b175ccb8e94
```
- Create가 된 상태라면 employee Deployment의 수정이 이루어지고, Create가 된 상태가 아니라면 employee Deployment를 Create 해주는 명령어입니다.  
#

### employee Deployment가 정상적으로 생성되었는지 확인하시려면 아래의 명령어를 실행하세요.

```
$ kubectl get Deployment

NAME            READY   UP-TO-DATE   AVAILABLE   AGE
employee           3/3     3            3           5m43s

```
- employee Deployment와 Pod, Replicaset이 모두 확인이 된다면 정상적으로 생성된 것입니다.
#

### 생성된 employee Deployment의 상세 실행 정보를 확인하시려면 아래의 명령어를 입력하세요.

```
$ kubectl describe Deployment employee
```
- employee Deployment의 상태를 확인하여 문제가 있는지 확인합니다. 
#

### Kubernetes Cluster network 외부에서 service에 access할 때, 해당 명령어로 외부 IP traffic을 허용할 수 있습니다.

```
$ kubectl port-forward Deployment/employee 8080:8080
```
#

### employee Deployment를 삭제하려면 아래의 명령어를 실행하세요.

```
$ kubectl delete Deployment employee
```
#

