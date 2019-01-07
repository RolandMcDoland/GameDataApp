// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package pl.put.poznan.gamebase.service.api;

import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.put.poznan.gamebase.service.api.ReviewService;
import pl.put.poznan.gamebase.structures.Game;
import pl.put.poznan.gamebase.structures.Review;
import pl.put.poznan.gamebase.structures.Reviewer;

privileged aspect ReviewService_Roo_Service {
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Review
     */
    public abstract Review ReviewService.findOne(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param review
     */
    public abstract void ReviewService.delete(Review review);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entities
     * @return List
     */
    public abstract List<Review> ReviewService.save(Iterable<Review> entities);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     */
    public abstract void ReviewService.delete(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param entity
     * @return Review
     */
    public abstract Review ReviewService.save(Review entity);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param id
     * @return Review
     */
    public abstract Review ReviewService.findOneForUpdate(Long id);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @return List
     */
    public abstract List<Review> ReviewService.findAll(Iterable<Long> ids);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return List
     */
    public abstract List<Review> ReviewService.findAll();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    public abstract long ReviewService.count();
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Review> ReviewService.findAll(GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Review> ReviewService.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param game
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Review> ReviewService.findByGame(Game game, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param reviewer
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Review> ReviewService.findByReviewer(Reviewer reviewer, GlobalSearch globalSearch, Pageable pageable);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param game
     * @return Long
     */
    public abstract long ReviewService.countByGame(Game game);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param reviewer
     * @return Long
     */
    public abstract long ReviewService.countByReviewer(Reviewer reviewer);
    
}
