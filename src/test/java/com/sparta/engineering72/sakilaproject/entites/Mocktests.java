package com.sparta.engineering72.sakilaproject.entites;
import com.sparta.engineering72.sakilaproject.controller.ActorController;
import com.sparta.engineering72.sakilaproject.controller.CategoryController;
import com.sparta.engineering72.sakilaproject.controller.CustomerController;
import com.sparta.engineering72.sakilaproject.controller.FilmController;
import com.sparta.engineering72.sakilaproject.entities.*;
import com.sparta.engineering72.sakilaproject.respositories.*;
import com.sparta.engineering72.sakilaproject.services.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.Silent.class)
public class Mocktests{


    @Spy
    ActorRepository actorRepository;
    @Spy
    FilmRepository filmRepository;
    @Spy
    CustomerRepository customerRepository;

    @Spy
    CategoryRepository categoryRepository;

    @Spy
    StaffRepository staffRepository;

    @Spy
    StoreRepository storeRepository;

    @Spy
    LanguageRepository languageRepository;

    @Spy
    RentalRepository rentalRepository;

    @Spy
    PaymentRepository paymentRepository;

    @Spy
    InventoryRepository inventoryRepository;

    @Spy
    FilmTextRepository filmTextRepository;

    @Spy
    CountryRepository countryRepository;

    @Spy
    CityRepository cityRepository;

    @Spy
    FilmCategoryRepository filmCategoryRepository;

    @Spy
    AddressRepository addressRepository;



    @Spy @InjectMocks
    ActorService actorService;

    @Spy @InjectMocks
    CategoryService categoryService;

    @Spy @InjectMocks
    FilmService filmService;

    @Spy @InjectMocks
    CustomerService customerService;

    @Spy @InjectMocks
    FilmActorService filmActorService;

    @Spy @InjectMocks
    FilmCategoryService filmCategoryService;


    @InjectMocks
    ActorController actorController;

    @InjectMocks
    CustomerController customerController;

    @InjectMocks
    FilmController filmController;

    @InjectMocks
    CategoryController categoryController;

    @Before()
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testActorbyId() {
        Actor actor = new Actor();
        actor.setActorId(10);
        when(actorRepository.getActorByActorId(10)).thenReturn(actor);
        Actor a = actorController.findActorById(10);
        System.out.println(actor.getFirstName());
        assertEquals(10, a.getActorId());
    }

    @Test
    public void testActorbyFirstName() {
        Actor actor1 = new Actor();
        actor1.setFirstName("Frank");
        actor1.setActorId(1);
        when(actorRepository.getActorByActorId(1)).thenReturn((actor1));
        Actor aa = actorController.findActorById(1);
        assertEquals("Frank", aa.getFirstName());
    }

    @Test
    public void testActorbyLastName() {
        Actor actor2 = new Actor();
        actor2.setLastName("Gomez");
        actor2.setActorId(2);
        when(actorRepository.getActorByActorId(2)).thenReturn((actor2));
        Actor aaa = actorController.findActorById(2);
        assertEquals("Gomez", aaa.getLastName());
    }

    @Test
    public void testActorbyMore() {
        Actor actor3 = new Actor();
        actor3.setFirstName("Justin");
        actor3.setActorId(3);
        actor3.setLastName("Timberlake");
        when(actorRepository.getActorByActorId(3)).thenReturn((actor3));
        Actor aaaa = actorController.findActorById(3);
        assertEquals("Justin", aaaa.getFirstName());
        assertEquals("Timberlake", aaaa.getLastName());
    }

    @Test
    public void testActorbyFullName() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Actor actor4 = new Actor();
        actor4.setFirstName("Leo");
        actor4.setActorId(3);
        actor4.setLastName("DiCaprio");
        actor4.setLastUpdate(timestamp);
        when(actorRepository.getActorByActorId(3)).thenReturn((actor4));
        Actor aaaa = actorController.findActorById(3);
        assertEquals(timestamp.toString(),aaaa.getLastUpdate().toString());
    }

    @Test
    public void testFilmByID() {
        FilmActor theFilmActor = new FilmActor();
        Actor filmActor = new Actor();
        theFilmActor.setActor(filmActor);
        Film film = new Film();
        film.setFilmId(1);
        when(filmRepository.getFilmByFilmId(1)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(1);
        assertEquals(1, theFilm.getFilmId());
    }

    @Test
    public void testFilmByDescritption() {
        Film film = new Film();
        film.setDescription("Horror");
        film.setFilmId(2);
        when(filmRepository.getFilmByFilmId(2)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(2);
        assertEquals("Horror", theFilm.getDescription());
    }

    @Test
    public void testFilmbyRating() {
        Film film = new Film();
        film.setRating("18");
        film.setFilmId(3);
        when(filmRepository.getFilmByFilmId(3)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(3);
        assertEquals("18", theFilm.getRating());
    }

    @Test
    public void testFilmbyLength() {
        Film film = new Film();
        film.setLength(200);
        film.setFilmId(4);
        when(filmRepository.getFilmByFilmId(4)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(4);
        assertEquals(200, theFilm.getLength());
    }

    @Test
    public void testFilmbyName() {
        Film film = new Film();
        film.setTitle("Goodfellas");
        film.setFilmId(5);
        when(filmRepository.getFilmByFilmId(5)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(5);
        assertEquals( "Goodfellas" , theFilm.getTitle());
    }

    @Test
    public void testFilmbyDescription() {
        Film film = new Film();
        film.setDescription("This is a long description");
        film.setFilmId(5);
        when(filmRepository.getFilmByFilmId(5)).thenReturn((film));
        Film theFilm = film;
        assertEquals( "This is a long description" , theFilm.getDescription());
    }


    @Test
    public void testFilms() {
        Language language1 = new Language();
        language1.setName("Italian");
        Language language2 = new Language();
        language2.setName("Latin");
        Date date = new Date();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Film film = new Film();
        film.setLastUpdate(timestamp);
        film.setTitle("Goodfellas");
        film.setFilmId(5);
        film.setSpecialFeatures("Special");
        film.setReplacementCost(BigDecimal.valueOf(0.999));
        film.setRentalRate(BigDecimal.valueOf(0.888));
        Byte theByte = 10;
        film.setRentalDuration(theByte);
        film.setLanguage1(language1);
        film.setLanguage2(language2);
        film.setReleaseYear(date);
        when(filmRepository.getFilmByFilmId(5)).thenReturn((film));
        Film theFilm = film;
        assertEquals( timestamp.toString() , theFilm.getLastUpdate().toString());
        assertEquals(  theByte, theFilm.getRentalDuration());
        assertEquals(  BigDecimal.valueOf(0.999), theFilm.getReplacementCost());
        assertEquals(  BigDecimal.valueOf(0.888), theFilm.getRentalRate());
        assertEquals(  "Italian", theFilm.getLanguage1().getName());
        assertEquals(  "Latin", theFilm.getLanguage2().getName());
        assertEquals(  date.toString(), theFilm.getReleaseYear().toString());



    }


    @Test
    public void testCategorybyId() {
        Category category = new Category();
        category.setCategoryId(10);
        when(categoryRepository.getCategoryByCategoryId(10)).thenReturn((category));
        Category secondCategory = categoryController.getCategorybyId(10);
        assertEquals( 10 , secondCategory.getCategoryId());
    }



    @Test
    public void testCategorybyName() {
        Category category = new Category();
        category.setName("Category");
        category.setCategoryId(10);
        when(categoryRepository.getCategoryByCategoryId(10)).thenReturn((category));
        Category secondCategory = category;
        assertEquals( 10 , secondCategory.getCategoryId());
    }

    @Test
    public void testCustomerById() {
        Address address = new Address();
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setCustomerId(10);
        when(customerRepository.getCustomerByCustomerId(10)).thenReturn((customer));
        Customer secondCustomer = customer;
        assertEquals( 10 , secondCustomer.getCustomerId());
    }


    @Test
    public void testPayment() {
        Payment payment = new Payment();
        Staff staff = new Staff();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        staff.setStaffId(10);
        Rental rental = new Rental();
        rental.setRentalId(10);
        payment.setStaff(staff);
        payment.setRental(rental);
        payment.setPaymentId(10);
        payment.setAmount(BigDecimal.valueOf(0.999));
        payment.setLastUpdate(timestamp);
        payment.setPaymentDate(date);
        when(paymentRepository.getPaymentByPaymentId(10)).thenReturn((payment));
        Payment secondPayment = payment;
        assertEquals( 10 , secondPayment.getPaymentId());
        assertEquals( 10 , secondPayment.getStaff().getStaffId());
        assertEquals( 10 , secondPayment.getRental().getRentalId());
        assertEquals( BigDecimal.valueOf(0.999) , secondPayment.getAmount());
        assertEquals( timestamp.toString() , payment.getLastUpdate().toString());
        assertEquals( date.toString() , payment.getPaymentDate().toString());
    }


    @Test
    public void testCustomer() {
        Date date = new Date();
        Store store = new Store();
        Customer customer = new Customer();
        customer.setEmail("email");
        customer.setCustomerId(10);
        customer.setCreateDate(date);
        customer.setFirstName("Paul");
        customer.setLastName("Watson");
        customer.setStore(store);
        when(customerRepository.getCustomerByCustomerId(10)).thenReturn((customer));
        Customer secondCustomer = customer;
        assertEquals( 10 , secondCustomer.getCustomerId());
        assertEquals( "email" , secondCustomer.getEmail());
        assertEquals( date , secondCustomer.getCreateDate());
        assertEquals( "Paul" , secondCustomer.getFirstName());
        assertEquals( "Watson" , secondCustomer.getLastName());

    }


    @Test
    public void testStaff() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Staff staff = new Staff();
        staff.setEmail("email");
        staff.setStaffId(10);
        staff.setFirstName("Paul");
        staff.setLastName("Watson");
        staff.setLastUpdate(timestamp);
        staff.setPassword("Password");
        staff.setUsername("Username");
        when(staffRepository.getStaffByFilmId(10)).thenReturn((staff));
        Staff secondstaff = staff;
        assertEquals( 10 , secondstaff.getStaffId());
        assertEquals( "email" , secondstaff.getEmail());
        assertEquals( "Paul" , secondstaff.getFirstName());
        assertEquals( "Watson" , secondstaff.getLastName());
        assertEquals( timestamp.toString(), secondstaff.getLastUpdate().toString());
        assertEquals( "Password" , secondstaff.getPassword());
        assertEquals( "Username" , secondstaff.getUsername());

    }

    @Test
    public void testFilmCategory()
    {
        Category category = new Category();
        category.setName("Drama");
        Film film = new Film();
        film.setTitle("Wolf of Wall Street");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FilmCategory filmCategory  = new FilmCategory();
        filmCategory.setCategory(category);
        filmCategory.setFilm(film);
        filmCategory.setLastUpdate(timestamp);
        when(filmCategoryRepository.getFilmCategoryById(10)).thenReturn((filmCategory));
        FilmCategory secondFilmCategory = filmCategory;
        assertEquals( "Drama" , secondFilmCategory.getCategory().getName());
        assertEquals( "Wolf of Wall Street" , secondFilmCategory.getFilm().getTitle());
        assertEquals( timestamp.toString() , secondFilmCategory.getLastUpdate().toString());

    }



    @Test

    public void testAddress()

    {
        City city = new City();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        city.setCity("London");
        Address address = new Address();
        address.setAddress("My Address");
        address.setAddress2("My Second Address");
        address.setAddressId(10);
        address.setCity(city);
        address.setDistrict("London");
        address.setLastUpdate(timestamp);
        address.setPhone("1010");
        address.setPostalCode("WCIX LXX");
        when(addressRepository.getAddressById(10)).thenReturn((address));
        Address secondAddress = address;
        assertEquals( "My Address" , secondAddress.getAddress());
        assertEquals( "My Second Address" , secondAddress.getAddress2());
        assertEquals( 10 , secondAddress.getAddressId());
        assertEquals( "London" , secondAddress.getDistrict());
        assertEquals( "1010" , secondAddress.getPhone());
        assertEquals( "WCIX LXX" , secondAddress.getPostalCode());
        assertEquals( timestamp.toString() , secondAddress.getLastUpdate().toString());
        assertEquals( "London" , secondAddress.getCity().getCity());











    }

    @Test

    public void testCity()
    {
        City city = new City();

        Country country = new Country();
        country.setCountry("Argentina");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        city.setCity("New York");
        city.setCityId(10);
        city.setCountry(country);
        city.setLastUpdate(timestamp);
        when(cityRepository.getCityById(10)).thenReturn(city);
        City secondCity = city;
        assertEquals( "Argentina" , secondCity.getCountry().getCountry());
        assertEquals( "New York" , secondCity.getCity());
        assertEquals( timestamp.toString() , secondCity.getLastUpdate().toString());
        assertEquals( 10 , secondCity.getCityId());

    }

    @Test

    public void testFilmController()

    {
        ModelMap modelMap = new ModelMap();
        FilmController filmController = new FilmController(filmService);
        String result = filmController.getFilmDetails(modelMap , 10);
        assertEquals( result , "films/filmDetails");


    }

    @Test

    public void testFilmController2()

    {
        ModelMap modelMap = new ModelMap();
        FilmController filmController = new FilmController(filmService);
        String result = filmController.getFilms(modelMap , "Filter");
        assertEquals( result ,  "/films/films");


    }


    @Test

    public void testCategory()

    {
        ModelMap modelMap = new ModelMap();
        CategoryController categoryController = new CategoryController(categoryService,filmCategoryService);
        String result = categoryController.getCategoryDetails(modelMap , 10);
        assertEquals( result ,  "categories/categoryDetails");
    }


    @Test

    public void testCategory2()

    {
        ModelMap modelMap = new ModelMap();
        CategoryController categoryController = new CategoryController(categoryService,filmCategoryService);
        String result = categoryController.getCategories(modelMap);
        assertEquals( result ,  "/categories/categories");

    }



    @Test

    public void testActorController1()

    {
        ModelMap modelMap = new ModelMap();
        ActorController actorController = new ActorController(filmService , actorService , filmActorService);
        String result = actorController.getActors(modelMap , "FirstName" , "LastName");
        assertEquals( result ,   "actors/actors");

    }



    @Test

    public void testCustomerController()

    {
        ModelMap modelMap = new ModelMap();
        CustomerController customerController = new CustomerController(customerService);
        String result = customerController.getAllCustomers(modelMap);
        assertEquals( result ,   "restricted/customers");

    }

    @Test

    public void testCustomerController2()

    {
        ModelMap modelMap = new ModelMap();
        CustomerController customerController = new CustomerController(customerService);
        String result = customerController.getCustomer(modelMap , 10);
        assertEquals( result ,   "restricted/customer");

    }


    @Test
    public void testStore() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Address address = new Address();
        Staff staff = new Staff();
        staff.setFirstName("Peter");
        staff.setLastName("Singer");
        Store store = new Store();
        store.setStoreId(10);
        store.setAddress(address);
        store.setLastUpdate(timestamp);
        store.setStaff(staff);
        when(storeRepository.getStoreByFilmId(10)).thenReturn((store));
        Store secondStore = store;
        assertEquals( 10 , secondStore.getStoreId());
        assertEquals( address.toString() , secondStore.getAddress().toString());
        assertEquals( timestamp.toString() , secondStore.getLastUpdate().toString());
        assertEquals( "Peter", store.getStaff().getFirstName());
        assertEquals( "Singer", store.getStaff().getLastName());

    }

    @Test
    public void testInventory() {
        Language language2 = new Language();
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        Timestamp timestamp1 = new Timestamp(timestamp.getTime());
        language2.setName("French");
        Store store = new Store();
        Film film = new Film();
        film.setLanguage2(language2);
        film.setReleaseYear(date);
        film.setLastUpdate(timestamp);
        Inventory inventory = new Inventory();
        inventory.setFilm(film);
        inventory.setInventoryId(10);
        inventory.setLastUpdate(timestamp1);
        inventory.setStore(store);
        when(inventoryRepository.getInventoryById(10)).thenReturn((inventory));
        Inventory secondInventory = inventory;
        assertEquals( 10 , secondInventory.getInventoryId());
        assertEquals( "French" , secondInventory.getFilm().getLanguage2().getName());
        assertEquals( timestamp.toString() , secondInventory.getFilm().getLastUpdate().toString());
        assertEquals( timestamp1.toString() , secondInventory.getLastUpdate().toString());
        assertEquals( store.toString(), secondInventory.getStore().toString());
        System.out.println(date.toString());



    }

    @Test
    public void testFilmText() {

        FilmText filmText = new FilmText();
        filmText.setDescription("Description");
        filmText.setFilmId(10);
        filmText.setTitle("Title");
        when(filmTextRepository.getFilmTextById(10)).thenReturn((filmText));
        FilmText secondFilmText = filmText;
        assertEquals( 10 , secondFilmText.getFilmId());
        assertEquals( "Description" , secondFilmText.getDescription());
        assertEquals( "Title", secondFilmText.getTitle());

    }


    @Test
    public void testCountry() {

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Country country = new Country();
        country.setCountry("Iraq");
        country.setCountryId(33);
        country.setLastUpdate(timestamp);

        when(countryRepository.getCountryByCountryId(33)).thenReturn((country));
        Country secondCountry = country;
        assertEquals( 33 , secondCountry.getCountryId());
        assertEquals( "Iraq" , secondCountry.getCountry());
        assertEquals( timestamp.toString(), secondCountry.getLastUpdate().toString());

    }


    @Test
    public void testLangage() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Language language = new Language();
        language.setName("Arabic");
        language.setLanguageId(10);
        language.setLastUpdate(timestamp);
        when(languageRepository.getLanguageByLanguageId(10)).thenReturn((language));
        Language secondLanguage = language;
        assertEquals( 10 , secondLanguage.getLanguageId());
        assertEquals( "Arabic" , secondLanguage.getName());
        assertEquals( timestamp.toString() , secondLanguage.getLastUpdate().toString());

    }

    @Test
    public void testRental() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        Date date1 = new Date();
        Inventory inventory = new Inventory();
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Peak");
        Staff staff = new Staff();
        staff.setFirstName("Paul");
        staff.setLastName("Watson");
        Rental rental = new Rental();
        rental.setRentalId(10);
        rental.setReturnDate(date);
        rental.setRentalDate(date1);
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setLastUpdate(timestamp);
        rental.setStaff(staff);

        when(rentalRepository.getRentalByRentalId(10)).thenReturn((rental));
        Rental secondRental = rental;
        assertEquals( 10 , rental.getRentalId());
        assertEquals( inventory.toString() , rental.getInventory().toString());
        assertEquals( timestamp.toString() , rental.getLastUpdate().toString());
        assertEquals( "James", rental.getCustomer().getFirstName());
        assertEquals( "Peak", rental.getCustomer().getLastName());
        assertEquals( "Paul", rental.getStaff().getFirstName());
        assertEquals( "Watson", rental.getStaff().getLastName());
        assertEquals( date.toString(), rental.getReturnDate().toString());
        assertEquals( date1.toString(), rental.getRentalDate().toString());


    }

    @Test
    public void testCategorybyTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Category category = new Category();
        category.setLastUpdate(timestamp);
        category.setCategoryId(10);
        when(categoryRepository.getCategoryByCategoryId(10)).thenReturn((category));
        Category secondCategory = category;
        assertEquals( timestamp.toString() , secondCategory.getLastUpdate().toString());
    }

    @Test
    public void testFilmByActor() {
        FilmActor theFilmActor = new FilmActor();
        Actor filmActor = new Actor();
        filmActor.setFirstName("Paul");
        filmActor.setLastName("Newman");
        filmActor.setActorId(10);
        theFilmActor.setActor(filmActor);
        Film film = new Film();
        film.setFilmId(1);
        when(filmRepository.getFilmActor(filmActor)).thenReturn((filmActor));
        assertEquals("Paul", theFilmActor.getActor().getFirstName());
        assertEquals("Newman", theFilmActor.getActor().getLastName());
        assertEquals(10, theFilmActor.getActor().getActorId());

    }


}
