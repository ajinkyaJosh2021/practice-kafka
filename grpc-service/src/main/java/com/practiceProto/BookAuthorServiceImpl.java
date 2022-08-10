package com.practiceProto;


import io.grpc.stub.StreamObserver;

public class BookAuthorServiceImpl extends bookAuthorServiceGrpc.bookAuthorServiceImplBase{

    @Override
    public void getAuthor(author request, StreamObserver<author> responseObserver) {
        super.getAuthor(request, responseObserver);
    }
}
