# TurkeyAPI from https://turkiyeapi.dev/

REST API for provinces and districts of Turkiye

ADD AS DEPENDENCY
-------------

 ```xml
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
```

```xml
     <dependency>
            <groupId>com.github.guneyilmaz0</groupId>
            <artifactId>TurkeyAPI</artifactId>
            <version>VERSION</version>
     </dependency>
````

### Usage

```kt
    val province = getProvinceByName("Antalya")
    print(province.id)
    val district = getDistrictByName("Antalya", "Muratpaşa")
    print(district.id)
```
