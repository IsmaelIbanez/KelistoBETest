# KelistoBETest
In this project, a MVC layered structure has been applied, omitting the views layer, since all interaction is done through the console.
## Structure
### Controller
The controller layer has the CheckoutController and a package called services, where all the hard logics are done. It's make in this way to keep the controller as clean as possible and have an easily access to understand what it is doing. That also serves to use multiple services in different controller, so you dont need to duplicate code.

### Model
It's divided in three: the own repositories, the entities and the mappers.

#### Entities
We have two principal entities in our model, the products and the message. These classes are used to handle and specific type of information between the different layers.

#### Mappers 
To map all the response from our DB/API's. In this case we are using an external API to get the currency exchange at the moment of the checkout.


## My locks
The only thing I wasn't able to do was the dockerize. I never did that and all the tutorials I found were quite "simple". Some information was being missed along the way of the tutorial. 

