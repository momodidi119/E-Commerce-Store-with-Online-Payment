#### 1.Add address

** POST /shippings


> request

```
receiverName=Hanna Han
receiverPhone=010
receiverMobile=18688888888
receiverProvince=Beijing
receiverCity=Beijing
receiverDistrict=Haidian
receiverAddress=Haidian
receiverZip=100000
```

> response

success

```
{
    "status": 0,
    "msg": "The address has been added successfully",
    "data": {
        "shippingId": 28
    }
}
```

fail
```
{
    "status": 1,
    "msg": "Fail"
}
```


------


#### 2.Delete Address

**DELETE /shippings/{shippingId}

DELETE /shippings/28

> request

```
shippingId
```

> response

success

```
{
    "status": 0,
    "msg": "Delete the address successfully"
}
```

fail
```
{
    "status": 1,
    "msg": "Fail"
}
```


------


#### 3.Update the address

**PUT /shippings/{shippingId}

> request

```
receiverName=Hanna Han
receiverPhone=010
receiverMobile=18688888888
receiverProvince=Tianjin
receiverCity=Tianjin
receiverDistrict=Nankai
receiverAddress=Nankai
receiverZip=100000
```

> response

success

```
{
    "status": 0,
    "msg": "Sucessfully"
}
```

fail
```
{
    "status": 1,
    "msg": "fail"
}
```


------


####4.List of address

**GET /shippings**

> request

```
pageNum(默认1),pageSize(默认10)
```

> response

success

```
{
    "status": 0,
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "size": 2,
        "orderBy": null,
        "startRow": 1,
        "endRow": 2,
        "total": 2,
        "pages": 1,
        "list": [
            {
                "id": 4,
                "userId": 13,
                "receiverName": "hanna Han",
                "receiverPhone": "010",
                "receiverMobile": "18688888888",
                "receiverProvince": "Tianjin",
                "receiverCity": "Tianjin",
                "receiverDistrict": "Nankai",
                "receiverAddress": "Nankai",
                "receiverZip": "100000",
                "createTime": 1485066385000,
                "updateTime": 1485066385000
            },
            {
                "id": 5,
                "userId": 13,
                "receiverName": "hanna Han",
                "receiverPhone": "010",
                "receiverMobile": "18688888888",
                "receiverProvince": "Tianjin",
                "receiverCity": "Tianjin",
                "receiverDistrict": "Nankai",
                "receiverAddress": "Nankai",
                "receiverZip": "100000",
                "createTime": 1485066385000,
                "updateTime": 1485066385000
            }
        ],
        "firstPage": 1,
        "prePage": 0,
        "nextPage": 0,
        "lastPage": 1,
        "isFirstPage": true,
        "isLastPage": true,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 8,
        "navigatepageNums": [
            1
        ]
    }
}
```

fail
```
{
    "status": 1,
    "msg": "Search after login"
}
```