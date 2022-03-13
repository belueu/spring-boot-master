package dev.belueu.springbootpetclinicweb.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
//
//    @Mock
//    OwnerService ownerService;
//
//    @InjectMocks
//    OwnerController ownerController;
//
//    Set<Owner> owners;
//
//    MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        owners = new HashSet<>();
//        owners.add(Owner.builder().id(1L).build());
//        owners.add(Owner.builder().id(2L).build());
//
//        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
//    }
//
//    @Test
//    void findOwners() throws Exception {
//
//        mockMvc.perform(get("/owners/find"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/findOwners"));
//
//        verifyNoInteractions(ownerService);
//    }
//
//    @Test
//    void showOwner() throws Exception {
//        Owner george = new Owner();
//        george.setId(1L);
//        george.setLastName("Franklin");
//        Pet max = new Pet();
//        PetType dog = new PetType();
//        dog.setName("dog");
//        max.setPetType(dog);
//        george.setPets(Collections.singleton(max));
//        max.setId(1L);
//
//        when(ownerService.findById(anyLong())).thenReturn(george);
//
//        mockMvc.perform(get("/owners/{ownerId}", 1L))
//                .andExpect(status().isOk())
//                .andExpect(model().attribute("owner", hasProperty("lastName", is("Franklin"))))
//                .andExpect(model().attribute("owner", hasProperty("id", is(1L))))
//
//                .andExpect(view().name("owners/ownerDetails"));
//    }
//
//    @Test
//    void processFindFormReturnMany() throws Exception {
//        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(owners.stream().toList());
//
//        mockMvc.perform(get("/owners"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/ownerList"))
//                .andExpect(model().attribute("selections", hasSize(2)));
//    }
//
//    @Test
//    void processFindFormReturnOne() throws Exception {
//        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build()));
//
//        mockMvc.perform(get("/owners"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"));
//    }


}