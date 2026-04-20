ტექნოლოგიები
ბიბლიოთეკადანიშნულებაREST AssuredAPI ტესტირებაPlaywright (Java)UI ბრაუზერის ავტომატიზაციაTestNGტესტების მართვაJacksonJSON დესერიალიზაციაHamcrestAssertion-ები

ტესტები
1. moneyTransferTest
Remittance გვერდის ტესტი — ამოწმებს გადარიცხვის სისტემების ინფორმაციას.
რას ამოწმებს:

✅ API სტატუს კოდი 200
✅ სისტემების სახელები UI-ზე ემთხვევა API-ს
✅ ვალუტების ჩამონათვალი UI-ზე ემთხვევა API-ს

Endpoint: GET /api/v1/moneyTransfer/systems?locale=ka-GE

2. treasuryRatesTest
Treasury გვერდის ტესტი — ამოწმებს USD/GEL Forward Rate-ებს.
რას ამოწმებს:

✅ API სტატუს კოდი 200
✅ USD/GEL წყვილი არსებობს
✅ პერიოდები UI-ზე ემთხვევა API-ს
✅ Bid Rate-ები ემთხვევა (სიზუსტე: 0.00001)
✅ Ask Rate-ები ემთხვევა (სიზუსტე: 0.00001)

Endpoint: GET /api/v1/forwardRates/getForwardRates?locale=ka-GE

გაშვება
bash# ყველა ტესტი
mvn test

# კონკრეტული ტესტი
mvn test -Dtest=Tests#moneyTransferTest
mvn test -Dtest=Tests#treasuryRatesTest

კონფიგურაცია
Constants.java-ში განსაზღვრულია ყველა URL:
javaBASE_URL        = "https://apigw.tbcbank.ge"
Remittance_URL  = "https://tbcbank.ge/ka/other-products/money-transfers"
Treasury_URL    = "https://tbcbank.ge/ka/treasury-products?amount=100&ccyFrom=USD&ccyTo=GEL"
ბრაუზერი ეშვება headless=false რეჟიმში slowMo(100ms)-ით — საჭიროების შემთხვევაში BaseTest.java-ში შეიძლება შეცვლა.
