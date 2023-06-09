# laboratoryApp
This a laboratory programming application.
This application has been developed using Java Spring as it is requested in the internship application.

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

## Swagger : localhost:8080/swagger-ui.html

# Bu uygulama ile neler yapılabilir ?
Uygulamayı kullanarak laborant, patient, report oluşturabilirsiniz. Report oluştururken hasta adını ve soy adını relationship kurarak patient içerisinden alır. 

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
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/ece5b2f7-7c21-4436-96e9-0a2263e86ec9)

# Controllers
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/6ca05f22-f732-4d6b-86f1-cc7d83352b11)

# Hasta(patient) ekleme , silme , güncelleme , id'ye göre hastayı listeleme , tüm hastaları listeleme.
'http://localhost:8080/api/patient/add' (patient ekleme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/db80afab-5e7b-4c54-87df-1441fa7191c6)

'http://localhost:8080/api/patient/update' (patient güncelleme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/6b7c2eb7-e380-47da-862d-aa95bcf7f973)

'http://localhost:8080/api/laborant/5' (id'ye göre patient silme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/344324bc-ec09-417e-b93d-6e0eb4849ce6)

'http://localhost:8080/api/patient/1' (id'ye göre laborant listeleme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/fa5bd086-16ee-4669-af85-6099ce40cffa)

'http://localhost:8080/api/laborant/getAll' (tüm patientleri listeleme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/aba02445-8c6d-4ea1-a974-025119dff256)


# Laborant ekleme, silme, güncelleme, id'ye göre laborant listeleme , tüm laborantları listeleme.
'http://localhost:8080/api/laborant/add (laborant ekleme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/45230a74-af0f-4652-9138-472eb86cbb89)

 'http://localhost:8080/api/laborant/update' (laborant güncelleme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/03ee7ae6-c672-41d1-a639-11e6445d72ed)

'http://localhost:8080/api/laborant/1' (id'ye göre laborant silme)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/16fb4c05-3401-450c-a3e7-7ffb7ec63d47)

'http://localhost:8080/api/laborant/{id}?id=1' ( id'ye göre laborant listeleme.)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/3a10993b-8c66-479e-8862-d14d5f687cb3)

'http://localhost:8080/api/laborant/getAll' ( tüm laborantları listeleme.)
![image](https://github.com/cengarm/laboratoryApp/assets/126611512/b8bb03ad-029c-4a2b-8a0e-43da67fef67f)

### Ek olarak: Uygulama geliştirilirken ModelMapper kullanılmıştır.
            
     <dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>3.1.1</version>
		</dependency>


