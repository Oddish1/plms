package com.plms;

public class Book {
		private String title;
		private String author;
		private String description;
		private Integer publicationYear;

		public Book(String title, String author, String description, int publicationYear) {
				this.title = title;
				this.author = author;
				this.description = description;
				this.publicationYear = publicationYear;
		}

		public String getTitle() {
				return title;
		}

		public String getAuthor() {
				return author;
		}

		public String getDescription() {
				return description;
		}

		public int getPublicationYear() {
				return publicationYear;
		}
}
