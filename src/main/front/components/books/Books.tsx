import {Book} from "../book/Book";
import {bookStore} from "../../stores/bookStore";
import {BooksProps} from "./Books.props";
import { useEffect, useState, useCallback } from 'react'

export const Books = (props: BooksProps) => {
  const [books, setBooks] = useState([])
  const [openModal, setOpenModal] = useState(false)

  useEffect(() => {
    bookStore.fetchBooks()
    setBooks(bookStore.books)
  })

  const renderGreeting = useCallback(() => {
    return <div>{`Bonjour ${props.user} !`}</div>
  }, [props.user])

  const modalCreateBook = () => {
    return (
    <dialog>
      <form action="" method="get">
      <div>
        <label htmlFor="bookName">Titre du livre :</label>
    <input type="text" required id="title"/>
        <input type="text" id="author" required/>
        <input type="text" id="year" required/>
      <input type="submit" value="Ajouter mon livre" onClick={() => {
        setOpenModal(false)
        bookStore.createBook()
      }}/>
      </div>
      </form>
    </dialog>
    )
  }

  return (
    <>
      {renderGreeting}

      <div>
        {books.length ? (
          books.map((book) =>
            <Book title={book.title} author={book.author} year={book.year}/>)
        ) : (
          <button onClick={() => setOpenModal}>Ajouter un livre à la librarie</button>
        )}
      </div>
    </>
  )
}