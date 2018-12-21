# JsonPathPartialResponse
Partial Response of JsonPath



# Installation

```bash
mvn install
```



# Usage

If you access

`http://localhost:8081/json-path`

Then

```json
{
    "store": {
        "book": [
            {
                "category": "reference",
                "author": "Nigel Rees",
                "title": "Sayings of the Century",
                "price": 8.95
            },
            {
                "category": "fiction",
                "author": "Evelyn Waugh",
                "title": "Sword of Honour",
                "price": 12.99
            },
            {
                "category": "fiction",
                "author": "Herman Melville",
                "title": "Moby Dick",
                "isbn": "0-553-21311-3",
                "price": 8.99
            },
            {
                "category": "fiction",
                "author": "J. R. R. Tolkien",
                "title": "The Lord of the Rings",
                "isbn": "0-395-19395-8",
                "price": 22.99
            }
        ],
        "bicycle": {
            "color": "red",
            "price": 19.95
        }
    },
    "expensive": 10
}
```



If you access

`http://localhost:8081/json-path?fields=store.book..category`

Then

```json
[
    "reference",
    "fiction",
    "fiction",
    "fiction"
]
```



If you access

`http://localhost:8081/json-path?fields=store.book..["category","author"]`

Then

```json
[
    {
        "category": "reference",
        "author": "Nigel Rees"
    },
    {
        "category": "fiction",
        "author": "Evelyn Waugh"
    },
    {
        "category": "fiction",
        "author": "Herman Melville"
    },
    {
        "category": "fiction",
        "author": "J. R. R. Tolkien"
    }
]
```

