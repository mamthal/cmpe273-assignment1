package edu.sjsu.cmpe.library;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import edu.sjsu.cmpe.library.api.resources.BookResource;
import edu.sjsu.cmpe.library.api.resources.RootResource;
import edu.sjsu.cmpe.library.api.resources.AuthorResource;
import edu.sjsu.cmpe.library.api.resources.ReviewResource;
import edu.sjsu.cmpe.library.config.LibraryServiceConfiguration;
import edu.sjsu.cmpe.library.domain.Library;
public class LibraryService extends Service<LibraryServiceConfiguration> {

	private Library library = new Library(100);
    public static void main(String[] args) throws Exception {
    	new LibraryService().run(args);
    }

    @Override
    public void initialize(Bootstrap<LibraryServiceConfiguration> bootstrap) {
	bootstrap.setName("library-service");
    }

    @Override
    public void run(LibraryServiceConfiguration configuration, Environment environment) throws Exception {
	/** Root API */
	environment.addResource(RootResource.class);
	/** Books APIs */
	BookResource bookres = new BookResource(library);
	environment.addResource(bookres);
	/**Author API**/
	AuthorResource authorres = new AuthorResource(library);
	environment.addResource(authorres);
	/**Review API**/
	ReviewResource revres = new ReviewResource(library);
	environment.addResource(revres);
    }
}
