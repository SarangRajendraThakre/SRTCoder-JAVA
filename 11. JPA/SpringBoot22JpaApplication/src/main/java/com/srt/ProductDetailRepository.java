package com.srt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProductDetailRepository extends JpaRepository<ProductDetails, Integer>
{

}
 