## requirements
- java 1.8
- for intellij lombok plugins
- postgresql v>10
- nodejs v>10
- modalmapper download



// "service"            : bussines logic imiz icin bu katmani yaptik
// "repostory"          : data operasyonlarımız icin bu katmani yaptik
// "entity"             : ORM nesnelerimiz olustugu tablodaki alanlarimiz var
// "dto"                : disari yayinlayacagimiz api mizdaki alanlarin oldugu yer. (DataTransferObje)
// "util.TPage"         : springin Page classini kullanmadan kendi TPage classi yarattik. Cunku modalmapper ile birlikte kullanabilmek icin.
// "api"                : veritabanındaki verileri dışarı json formatında veri gondereceğimiz katman
// "advice"             : exception lari yonettigim paket



1. start.spring.io dan yeni spring projesi oluştur.
    a. dependncies olarak "web, rest reporsitories, lombok, jpa, postgresql" ekle
2. entity ler oluşturulur
3. repostory ler oluşturulur
4. service ler (interface ler yani) oluşturulur 
5. impl ler oluşturulur
6. dto lar oluşturulur
    a. dto oluşturulunca mevcut service ve impl içindeki class larda donusturulecek bu dto classına 
    b. Issue den IssueDTO ya donusturmek icin modalmapper ' kullanacağız
    c. modalmapper i pom a ekliyoruz. sonrasında da IssueManagementApplication 'a ekliyoruz.
7. normal Page sınıfını değil de TPage sınıfı oluşturup paginatiton u bu class dan yapacağız.
8. geçici db olarak h2 database yi pom a ekle
    a. application.properties de configleri yazılır.
9. api lar oluşturulur. uygulamaya dışardan ulaşılabilir hale getireceğiz.
10. api larin dökümantasyonu için "swagger" pom a eklenir ve uygun annotationlar api, entity e eklenir.
11. postgresql pom a eklenir.
    a. h2 nin scope i test yapilir sadece unittest lerde bu db kullanılır
    b. postgresql in scope i runtime yapılır
    c. application.properties de configleri yazılır
    d. dbvear indirilir.
    e. postgresql kurulur.
12. global exception yapısı kurulur.
13. api larda versiyonlama altyapısı kurulur.
14. projede loglama yapısı kurulur
15. projede test datası oluşturulur.
16. paginatiton desteği test edilir ve geliştirilir.






