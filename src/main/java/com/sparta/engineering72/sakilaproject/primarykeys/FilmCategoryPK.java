package com.sparta.engineering72.sakilaproject.primarykeys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class FilmCategoryPK implements Serializable {
    private Object filmId;
    private Object categoryId;

    @Column(name = "film_id")
    @Id
    public Object getFilmId() {
        return filmId;
    }

    public void setFilmId(Object filmId) {
        this.filmId = filmId;
    }

    @Column(name = "category_id")
    @Id
    public Object getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Object categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmCategoryPK that = (FilmCategoryPK) o;

        if (filmId != null ? !filmId.equals(that.filmId) : that.filmId != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId != null ? filmId.hashCode() : 0;
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }
}
