Lista de persoane:
GET - intoarce lista de persoane existente - lista de PersonDTO
localhost:8090/training/person/list
GET - intoarce doar prima persoane din baza - un PersonDTO
localhost:8090/training/person/first_list


Add new person:
POST
localhost:8090/training/person/create
Body (as JSON):
{"name":"Popa","firstName":"Ion","cnp":"1234567890123","icSeries":"AB","icNumber":235654,"birthDate":"11-12-2019","serviceSupplier":"Regina Maria","medicalSubscription":"Analize","genderType":"M","medicalHistory":["chronicDisease","surgicalInterventions","noProblem"],"observation":"abcd"}


Get person:
GET
localhost:8090/training/person/{id}}
localhost:8090/training/person/5df7a008d2110d318f892c24


Update
PUT
localhost:8090/training/person/update/{id}}
localhost:8090/training/person/update/5df7a008d2110d318f892c24
Body (as JSON):
{"name":"Pop","firstName":"Ioan","cnp":"5523532523523","icSeries":"TT","icNumber":222333,"birthDate":"11-12-2019","serviceSupplier":"Regina Maria","medicalSubscription":"Teste","genderType":"F","medicalHistory":["chronicDisease","surgicalInterventions"],"observation":"ddsgdsgds"}


Delete
DELETE
localhost:8090/training/person/{id}}
localhost:8090/training/person/5df7a008d2110d318f892c24


---------- DETALIERE --------

GET - intoarce lista de persoane existente - lista de PersonDTO
localhost:8090/training/person/list
Rezultat returnat:
[
    {
        "id": "5dfa43e2191fd22c0c0badbe",
        "name": "Onea",
        "firstName": "Gica",
        "cnp": "1234567890123",
        "icSeries": "AB",
        "icNumber": "235654",
        "birthDate": "2019-10-22",
        "serviceSupplier": "Regina Maria",
        "medicalSubscription": "Analize",
        "genderType": "M",
        "medicalHistory": [
            "chronicDisease",
            "surgicalInterventions",
            "noProblem"
        ],
        "observation": "abcd"
    },
    {
        "id": "5e020182da99b8272c723cd8",
        "name": "Tranc",
        "firstName": "Lica",
        "cnp": "1234567890123",
        "icSeries": "AB",
        "icNumber": "235654",
        "birthDate": "2019-12-13",
        "serviceSupplier": "Regina Maria",
        "medicalSubscription": "Analize",
        "genderType": "M",
        "medicalHistory": [
            "chronicDisease",
            "surgicalInterventions",
            "noProblem"
        ],
        "observation": "abcd"
    }
]



GET - intoarce doar prima persoane din baza - un PersonDTO
localhost:8090/training/person/first_list
Rezultat returnat:
{
    "id": "5dfa43e2191fd22c0c0badbe",
    "name": "Onea",
    "firstName": "Gica",
    "cnp": "1234567890123",
    "icSeries": "AB",
    "icNumber": "235654",
    "birthDate": "2019-10-22",
    "serviceSupplier": "Regina Maria",
    "medicalSubscription": "Analize",
    "genderType": "M",
    "medicalHistory": [
        "chronicDisease",
        "surgicalInterventions",
        "noProblem"
    ],
    "observation": "abcd"
}


GET
localhost:8090/training/person/{id}}
Rezultat returnat:
{
    "id": "5e85fbc764cdb0540db7f200",
    "name": "Dinu",
    "firstName": "Ion",
    "cnp": "1234567890123",
    "icSeries": "AB",
    "icNumber": "235654",
    "birthDate": "0016-06-10",
    "serviceSupplier": "Regina Maria",
    "medicalSubscription": "Analize",
    "genderType": "M",
    "medicalHistory": [
        "chronicDisease",
        "surgicalInterventions",
        "noProblem"
    ],
    "observation": "abcd"
}



Add new person:
POST
localhost:8090/training/person/create
Body (as JSON):
{"name":"Popa","firstName":"Ion","cnp":"1234567890123","icSeries":"AB","icNumber":235654,"birthDate":"11-12-2019","serviceSupplier":"Regina Maria","medicalSubscription":"Analize","genderType":"M","medicalHistory":["chronicDisease","surgicalInterventions","noProblem"],"observation":"abcd"}
Rezultat returnat: (rezultatul este optional - poate fi creeat un REST API fara sa intoarce ceva, sau sa intoarce un ID)
{
    "id": "5e85fbc764cdb0540db7f200",
    "name": "Dinu",
    "firstName": "Florin",
    "cnp": "1234567890123",
    "icSeries": "AB",
    "icNumber": "235654",
    "birthDate": "0018-06-11",
    "serviceSupplier": "Regina Maria",
    "medicalSubscription": "Analize",
    "genderType": "M",
    "medicalHistory": [
        "chronicDisease",
        "surgicalInterventions",
        "noProblem"
    ],
    "observation": "abcd"
}



Update
PUT
localhost:8090/training/person/update/{id}}
localhost:8090/training/person/update/5df7a008d2110d318f892c24
Body (as JSON):
{"name":"Pop","firstName":"Ioan","cnp":"5523532523523","icSeries":"TT","icNumber":222333,"birthDate":"11-12-2019","serviceSupplier":"Regina Maria","medicalSubscription":"Teste","genderType":"F","medicalHistory":["chronicDisease","surgicalInterventions"],"observation":"ddsgdsgds"}
Rezultat returnat: (rezultatul este optional - poate fi creeat un REST API fara sa intoarce ceva, sau sa intoarce un ID)
{
    "id": "5e85fbc764cdb0540db7f200",
    "name": "Dinu",
    "firstName": "Florin",
    "cnp": "1234567890123",
    "icSeries": "AB",
    "icNumber": "235654",
    "birthDate": "0018-06-11",
    "serviceSupplier": "Regina Maria",
    "medicalSubscription": "Analize",
    "genderType": "M",
    "medicalHistory": [
        "chronicDisease",
        "surgicalInterventions",
        "noProblem"
    ],
    "observation": "abcd"
}

Delete
DELETE
localhost:8090/training/person/{id}}
localhost:8090/training/person/5df7a008d2110d318f892c24
Rezultat returnat: (rezultatul este optional - poate fi creeat un REST API fara sa intoarce ceva, sau sa intoarce un ID)
{
    "id": "5e85fbc764cdb0540db7f200",
    "name": "Dinu",
    "firstName": "Florin",
    "cnp": "1234567890123",
    "icSeries": "AB",
    "icNumber": "235654",
    "birthDate": "0018-06-11",
    "serviceSupplier": "Regina Maria",
    "medicalSubscription": "Analize",
    "genderType": "M",
    "medicalHistory": [
        "chronicDisease",
        "surgicalInterventions",
        "noProblem"
    ],
    "observation": "abcd"
}