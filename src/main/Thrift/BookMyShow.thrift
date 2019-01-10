namespace java org.BookMyShow.thrift.gen
typedef i32 int
//TODO: naming convention, Enums
struct MovieThrift{
    1:string id;
    2:string name;
    3:string releaseDate;
    4:int rating;
}

struct UserThrift{
    1:string id;
    2:string uname;
    3:string upass;
}
struct TheaterThrift{
    1:string id;
    2:string name;
    3:string city;
    4:string address;

}

struct SeatThrift{
    1:string id;
    2:string name;
    3:string theaterId;

}

struct ShowThrift{
    1:string id;
    2:string movieId;
    3:string theaterId;
    4:string dateTime;
}
struct InventoryThrift{
    1:string seatId;
    2:string dateTime;
    3:bool status;
}
service MovieTService{
    bool ping(),
    list<MovieThrift> getAllMovie(),
}

service UserTService{
    bool ping(),
    list<UserThrift> getAllUser(),
    bool loginUser(1:string uname,2:string upass),
    string registerUser(1:string uname,2:string upass),
}


service ShowTService{
    bool ping(),
    list<ShowThrift> getAllShow(),
    list<ShowThrift> getShows(1:string theaterId,2:string dateTime),
}

service SeatTService{
    list<InventoryThrift> getSeats(1:ShowThrift show),
    list<InventoryThrift> bookSeats(1:list<string> seatIds,2:string dateTime),
}





