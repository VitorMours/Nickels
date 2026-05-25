import { Test, TestingModule } from '@nestjs/testing';
import type { User } from "./entities/users.entity";
import { UsersController } from "./users.controller";
import { UsersService } from "./users.service";

describe("UsersController", () => {
  let controller: UsersController;
  let service: UsersService;

  // Configuração do módulo de teste do NestJS
  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [UsersController],
      providers: [
        {
          provide: UsersService,
          useValue: {
            findAll: jest.fn(), 
          },
        },
      ],
    }).compile();

    controller = module.get<UsersController>(UsersController);
    service = module.get<UsersService>(UsersService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
    expect(service).toBeDefined();
  });

  describe("getUsers", () => {
    it("should return all users, or none", async () => {
      const result: User[] = []; 
      jest.spyOn(service, 'findAll').mockResolvedValue(result);

      expect(await controller.getUsers()).toEqual([]);
    });

    it("should return one user", async () => {
      const mockUser: User = {
        id: 1,
        firstName: "John Doe",
        email: "john.doe@example.com",
        password: "password123",
        createdAt: new Date(),
        updatedAt: new Date()
      };

      jest.spyOn(service, 'findAll').mockResolvedValueOnce([mockUser]);
      const result = await controller.getUsers();
      expect(result).toEqual([mockUser]);
      expect(result.length).toEqual(1);
      expect(service.findAll).toHaveBeenCalledWith();
    });
  });

  describe("getUserById", () => {
    it("should return one user finded by id or none", async () => {
      const result: User[] = [];
    });
  });
});