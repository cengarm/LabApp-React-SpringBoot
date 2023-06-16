# LabApp
This a laboratory programming application.
# Project Installation and Running 

## Requirements:
Tech:
- Maven 
- Java 
- React
- PostgreSQL

[Frontend readme](https://github.com/cengarm/LabApp-React-SpringBoot/blob/main/LabApp%20-Frontend%20(React)/README.md)

Database:

        spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.hibernate.show-sql=true
        spring.datasource.url=jdbc:postgresql://localhost:5432/Lab   ==> Dont forget change
        spring.datasource.username=postgres
        spring.datasource.password=123456   ==> Dont forget change
        spring.jpa.properties.javax.persistence.validation.mode = none

## Installation
1-Clone this repo 
```sh
git clone https://github.com/cengarm/LabApp.git
```
2-Then navigate to the path where the labapp project is located in the Terminal
```sh
cd labapp-backend
```
3-Create Jar file for the project
```sh
mvn package
```
4-Then go lab-app target folder
```sh
cd target
```

## Running

5-Run Jar project file
```sh
java -jar lab-0.0.1-SNAPSHOT.jar
```

This a laboratory programming application.
This application has been developed using Java Spring as it is requested in the internship application.

![image](https://github.com/cengarm/LabApp-React-SpringBoot/assets/126611512/7a7d9e02-3325-47df-8fbe-1ddc9d843bf6)


# Internship program request:

Spring, JPA, Maven, React teknolojilerini kullanarak basit bir
laboratuvar raporlama uygulaması geliştirmenizi istiyoruz.

* Rapor Tanımı ( Dosya numarası, Hasta Ad ve Soyad, Hasta Kimlik
Numarası(TC), Koyulan Tanı Başlığı, Tanı Detayları, Raporun Verildiği
Tarih, Fiziksel Rapora Ait .png/.jpg Formatında Bir Adet Fotoğraf )
* Bir rapor yalnızca bir laborant tarafından tanımlanmış olmalı. Bir
laborant ise  n tane rapor tanımlayabilir. ( Ad, Soyad, Hastane Kimlik
Numarası(7 Haneli), )
* Hasta adı/soyadı, Hasta kimlik numarası, Laborant adı/soyadı
bilgileri ile arama yapılabilmeli. Rapor tarihi ile sıralama
yapılabilmeli
* Var olan bir rapor üzerinde değişiklik yapılabilmeli
* Var olan tüm raporların detayları incelenebilmeli
* Var olan bir rapor silinebilmeli

Beklentilerimiz:
* Kod standartlarına uygun yazılım geliştirilmesi
* Uygulamanın çalıştırılabilir hale getirilmesi için bir IDE
kullanılması gerekmemesi

Bir adım öne çıkayım derseniz:
* Birim test içermesi elbette bir artı olarak değerlendirilir.
* Kullanıcılar sisteme kullanıcı adı/parola ile giriş yapmalı
* Bir yetkilendirme mekanizması içermeli. Örneğin standart kullanıcılar
kayıt oluşturabilsin ilişkilendirebilsin fakat silemesin. Yönetici tüm
eylemleri gerçekleştirebilsin.

## Swagger : http://localhost:8080/swagger-ui.html

# Bu uygulama ile neler yapılabilir ?
Uygulamayı kullanarak laborant, patient, report oluşturabilirsiniz. Report oluştururken hasta adını ve soy adını relationship kurarak patient içerisinden alır. 
Database olarak postgreSQL kullandım.

    {
    "photoUrl": "string",
    "fileNumber": 0,
    "diseaseName": "string",
    "diseaseDetails": "string",
    "lobarantId": 0,
    "patientId": 0 
    }

# Relationships
### Report :


    @ManyToOne
    @JoinColumn(name = "lab_id")
    private Laborant laborant;
    
    @ManyToOne
    @JoinColumn(name = "p_fk_id")
    private Patient patient;
    
### Patient
    @ManyToOne 
    @JoinColumn(name = "patient_id")
    private Laborant laborant;

    @OneToMany(mappedBy = "patient")
    private List <Report> reports;
  
### Laborant
    @OneToMany(mappedBy = "laborant")
    @JsonIgnore
    private List <Report> reports;
    
# Unit-Test 
Laborant, Patient, Report Managerleri üzerinde sadece Create için testler yapılmıştır.

