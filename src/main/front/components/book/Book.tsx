import {BookProps} from "./Book.props";

export const Book = (props: BookProps) => {
return (
  <div>
    <h2>{props.title}</h2>
    <p>Ce livre est écrit par {props.author} en {props.year}.</p>
  </div>
  )
}