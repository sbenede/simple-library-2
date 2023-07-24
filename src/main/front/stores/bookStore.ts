import { observable, action } from 'mobx'
import { BookDto } from 'api'

export class bookStore {
  @observable
  public books: Array<BookDto> = [];

  @action
  public fetchBooks (): void {
    fetch('http://localhost:8080/books')
      .then(response => {
        if (!response.ok) {
          throw new Error(response.statusText)
        }
        return response.json()
      })
      .then((books: Array<BookDto>) => {
        this.books = books
      })
  }

  @action
  public createBook (book: BookDto) {
    fetch('http://localhost:8080/api/library/', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)
      })
      .then(res => res.json())
      .then(res => console.log(res));
  }
}