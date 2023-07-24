import {BookProps} from "./Book.props";
import styles from './Book.module.scss'

export const Book = (props: BookProps) => {
return (
  <div>
    <h2>{props.title}</h2>
    <p className={styles.description}>Ce livre est écrit par {props.author} en {props.year}.</p>
  </div>
  )
}